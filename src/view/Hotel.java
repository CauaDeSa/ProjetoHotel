package view;

import model.acomodacoes.*;
import model.enums.Estados;
import model.itensCosumo.ItensConsumo;
import model.pessoas.Administrador;
import model.pessoas.Funcionario;
import model.pessoas.Hospede;

import javax.swing.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Hotel {

  private int nivelAcesso;

  private List<Administrador> administradores;
  private List<Hospede> hospedes;
  private List<Funcionario> funcionarios;

  private List<ItensConsumo> itensConsumoDisponiveis;

  private List<Acomodacao> acomodacoesDisponiveis;
  private List<TipoAcomodacao> tiposAcomodacao;

  private List<Reserva> reservas;
  private List<Acomodado> acomodados;

  private final Scanner scanner = new Scanner(System.in);

  public Hotel() {
    administradores = new ArrayList<>(5);
    hospedes = new ArrayList<>(100);
    funcionarios = new ArrayList<>(10);

    itensConsumoDisponiveis = new ArrayList<>(100);

    acomodacoesDisponiveis = new ArrayList<>(100);
    tiposAcomodacao = new ArrayList<>(10);

    reservas = new ArrayList<>(100);
    acomodados = new ArrayList<>(100);
  }

  public void init() {
    String opcao = "";
    String title = "Hotel";
    boolean quit = false;

    while (!quit) {

      int escolha;

      Object[] acessos = {
              "Sair",
              "Hospede",
              "Funcionario",
              "Administrador"};

      do {
        escolha = JOptionPane.showOptionDialog(null, "Escolha um acesso", title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, acessos, acessos[1]);
        nivelAcesso(escolha);
        if (nivelAcesso == -1) {
          quit = true;
        }
      } while (nivelAcesso == 0);

      while (!opcao.equals("Sair") && nivelAcesso > 0) {

        Object[] questions = {
                "Cadastrar administrador",
                "Cadastrar funcionario",
                "Cadastrar hospede",
                "Cadastrar acomodacao",
                "Cadastrar tipo de acomodacao",
                "Cadastrar item de consumo",
                "Cadastrar reserva",
                "Cadastrar acomodado",
                "Cadastrar consumo",
                "Ver administradores",
                "Mudar acesso"};

        opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opcao", title, JOptionPane.QUESTION_MESSAGE, null, questions, questions[0]);

        menu(opcao);

      }
    }
  }

  private void nivelAcesso(int acesso) {

      int senha;

      switch (acesso) {
          case 3:
              // Senha para acesso de administrador
              senha = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a senha", "Acesso de administrador", JOptionPane.QUESTION_MESSAGE));
              if (senha != 1234) {
                  JOptionPane.showMessageDialog(null, "Senha incorreta");
              } else {
                  nivelAcesso = 3;
              }
              break;
          case 2:
              // Senha para entrar como funcionario
              senha = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a senha", "Acesso de funcionario", JOptionPane.QUESTION_MESSAGE));
              if (senha != 4321) {
                  JOptionPane.showMessageDialog(null, "Senha incorreta");
              } else {
                  nivelAcesso = 2;
              }
              break;
          case 1:
            //Entrar como hospede? Sim ou não
              if ( JOptionPane.showConfirmDialog(null, "Deseja entrar como hospede?", "Acesso de hospede", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                  nivelAcesso = 1;
              } else {
                nivelAcesso = 0;
              }
              break;
          case 0:
              // Sair...
              nivelAcesso = -1;
              break;
      }
  }

  private void menu(String opcao){
    switch (opcao) {
      case "Cadastrar administrador":
        cadastrarAdministrador();
        break;
//      case "Cadastrar funcionario":
//        cadastrarFuncionario();
//        break;
//      case "Cadastrar hospede":
//        cadastrarHospede();
//        break;
//      case "Cadastrar acomodacao":
//        cadastrarAcomodacao();
//        break;
//      case "Cadastrar tipo de acomodacao":
//        cadastrarTipoAcomodacao();
//        break;
//      case "Cadastrar item de consumo":
//        cadastrarItemConsumo();
//        break;
//      case "Cadastrar reserva":
//        cadastrarReserva();
//        break;
//      case "Cadastrar acomodado":
//        cadastrarAcomodado();
//        break;
//      case "Cadastrar consumo":
//        cadastrarConsumo();
//        break;
      case "Ver administradores":
        mostrarAdministradores();
        break;
      case "Mudar acesso":
        nivelAcesso = 0;
        break;
      case "Sair":
        System.out.println("Saindo...");
        break;
      default:
        System.out.println("Opcao invalida");
        break;
    }
  }

  private void cadastrarAdministrador() {

    String title = "Cadastrar administrador";

    String nome = JOptionPane.showInputDialog(null, "Digite o nome do administrador", title, JOptionPane.QUESTION_MESSAGE);
    int telefone = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o telefone do administrador", title, JOptionPane.QUESTION_MESSAGE));
    String cidade = JOptionPane.showInputDialog(null, "Digite a cidade do administrador", title, JOptionPane.QUESTION_MESSAGE);


    Object[] estados = new Object[Estados.values().length];
    System.arraycopy(Estados.values(), 0, estados, 0, estados.length);
    Estados estado = (Estados) JOptionPane.showInputDialog(null, "Escolha o estado do administrador", title, JOptionPane.QUESTION_MESSAGE, null, estados, estados[0]);

    LocalDate dataNascimento = null;
    boolean done = false;
    while (!done) {
      try {
        dataNascimento = LocalDate.parse(JOptionPane.showInputDialog(null, "Digite a data de nascimento do administrador", title, JOptionPane.QUESTION_MESSAGE));
        done = true;
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Data invalida", title, JOptionPane.ERROR_MESSAGE);
      }
    }

    administradores.add(new Administrador(nome, telefone, cidade, estado, dataNascimento));
  }

  private void mostrarAdministradores() {
    String title = "Administradores";
    StringBuilder message = new StringBuilder();

    for (Administrador administrador : administradores) {
      message.append(administrador.toString()).append("\n");
    }

    JOptionPane.showMessageDialog(null, message.toString(), title, JOptionPane.INFORMATION_MESSAGE);
  }

}
