package view;

import model.CartaoCredito;
import model.acomodacoes.Acomodacao;
import model.acomodacoes.Acomodado;
import model.acomodacoes.Reserva;
import model.acomodacoes.TipoAcomodacao;
import model.enums.Estados;
import model.enums.Identification;
import model.enums.TipoItens;
import model.itensCosumo.ItensConsumo;
import model.pessoas.Administrador;
import model.pessoas.Funcionario;
import model.pessoas.Hospede;
import model.pessoas.Pessoa;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static view.Hotel.formatterData;

/**
 * Classe que contém os métodos para cadastrar novos objetos no sistema.
 */
public class Cadastros {

  private static final Object[] estados = Estados.values();

  /**
   * Método para cadastrar um novo administrador do hotel.
   * @param administradores Lista de administradores do hotel.
   * @param usuario Usuario logado no sistema.
   */
  // Método para cadastrar um administrador
  public static void cadastrarAdministrador(List<Administrador> administradores, Pessoa usuario) {
    if (usuario instanceof Administrador) {

      // Janela de diálogo para coletar informações do administrador
      String title = "Cadastrar administrador";

      String nome = JOptionPane.showInputDialog(null, "Digite o nome do administrador", title,
              JOptionPane.QUESTION_MESSAGE);

      int telefone = Integer.parseInt(
              JOptionPane.showInputDialog(null, "Digite o telefone do administrador", title, JOptionPane.QUESTION_MESSAGE));

      String cidade = JOptionPane.showInputDialog(null, "Digite a cidade do administrador", title,
              JOptionPane.QUESTION_MESSAGE);

      Estados estado = (Estados) JOptionPane.showInputDialog(null, "Escolha o estado do administrador", title,
              JOptionPane.QUESTION_MESSAGE, null, estados, estados[0]);

      LocalDate dataNascimento = null;
      boolean done = false;
      while (!done) {
        try {
          dataNascimento = LocalDate.parse(JOptionPane.showInputDialog(null,
                  "Digite a data de nascimento do administrador", title, JOptionPane.QUESTION_MESSAGE), formatterData);
          done = true;
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Data invalida", title, JOptionPane.ERROR_MESSAGE);
        }
      }

      int key = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a senha do administrador", title,
              JOptionPane.QUESTION_MESSAGE));

      // Adicionar o administrador à lista
      administradores.add(new Administrador(nome, telefone, cidade, estado, dataNascimento, key));
    }
  }

  /**
   * Método que cadastra um novo funcionário no hotel.
   * @param funcionarios Lista de funcionarios do hotel.
   * @param usuario Usuario logado no sistema.
   */
  // Método para cadastrar um funcionário
  public static void cadastrarFuncionario(List<Funcionario> funcionarios, Pessoa usuario){
    if (usuario instanceof Administrador administrador){
      // Janela de diálogo para coletar informações do funcionário
      String title = "Cadastrar funcionario";

      String nome = JOptionPane.showInputDialog(null, "Digite o nome do funcionario", title,
              JOptionPane.QUESTION_MESSAGE);
      int telefone = Integer.parseInt( JOptionPane.showInputDialog(null, "Digite o telefone do funcionario", title,
              JOptionPane.QUESTION_MESSAGE));
      String cidade = JOptionPane.showInputDialog(null, "Digite a cidade do funcionario", title, JOptionPane.QUESTION_MESSAGE);

      Estados estado = (Estados) JOptionPane.showInputDialog(null, "Escolha o estado do funcionario", title,
              JOptionPane.QUESTION_MESSAGE, null, estados, estados[0]);

      LocalDate dataNascimento = null;
      boolean done = false;
      while (!done) {
        try {
          dataNascimento = LocalDate.parse(JOptionPane.showInputDialog(null,
                  "Digite a data de nascimento do funcionario", title, JOptionPane.QUESTION_MESSAGE), formatterData);
          done = true;
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Data invalida", title, JOptionPane.ERROR_MESSAGE);
        }
      }

      int key = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a senha do funcionario", title,
              JOptionPane.QUESTION_MESSAGE));

      // Adicionar o funcionário à lista
      administrador.cadastrarFuncionario(nome, telefone, cidade, estado, dataNascimento, key, funcionarios);
    }
  }

  /**
   * Método que cadastra um novo hóspede no hotel.
   * @param hospedes Lista de hospedes do hotel.
   * @param usuario Usuario logado no sistema.
   */
  public static void cadastrarHospede(List<Hospede> hospedes, Pessoa usuario) {
    if (usuario instanceof Funcionario funcionario) {
      // Janela de diálogo para coletar informações do hóspede
      String title = "Cadastrar hospede";


      String nome = JOptionPane.showInputDialog(null, "Digite o nome do hospede", title, JOptionPane.QUESTION_MESSAGE);
      int telefone = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o telefone do hospede", title,
              JOptionPane.QUESTION_MESSAGE));
      String cidade = JOptionPane.showInputDialog(null, "Digite a cidade do hospede", title, JOptionPane.QUESTION_MESSAGE);

      Estados estado = (Estados) JOptionPane.showInputDialog(null, "Escolha o estado do hospede", title,
              JOptionPane.QUESTION_MESSAGE, null, estados, estados[0]);

      LocalDate dataNascimento = null;
      boolean done = false;
      while (!done) {
        try {
          dataNascimento = LocalDate.parse(JOptionPane.showInputDialog(null,
                  "Digite a data de nascimento do hospede", title, JOptionPane.QUESTION_MESSAGE), formatterData);
          done = true;
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Data invalida", title, JOptionPane.ERROR_MESSAGE);
        }
      }

      String pais = JOptionPane.showInputDialog(null, "Digite o pais do hospede", title, JOptionPane.QUESTION_MESSAGE);

      String email = JOptionPane.showInputDialog(null, "Digite o email do hospede", title, JOptionPane.QUESTION_MESSAGE);

      Identification tipoDoc = (Identification) JOptionPane.showInputDialog(null, "Escolha o tipo do documento do hospede", title,
              JOptionPane.QUESTION_MESSAGE, null, Identification.values(), Identification.values()[0]);

      int numDoc = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do documento", title,
              JOptionPane.QUESTION_MESSAGE));

      String nomeMae = JOptionPane.showInputDialog(null, "Digite o nome da mae do hospede", title,
              JOptionPane.QUESTION_MESSAGE);

      String nomePai = JOptionPane.showInputDialog(null, "Digite o nome do pai do hospede", title,
              JOptionPane.QUESTION_MESSAGE);

      int senha = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a senha do hospede", title,
              JOptionPane.QUESTION_MESSAGE));

      // Adicionar o hóspede à lista
      funcionario.cadastrarHospede(new Hospede(nome, telefone, cidade,
              estado, dataNascimento, pais, email, tipoDoc, numDoc, nomeMae
              , nomePai, funcionario, senha), hospedes);
    }
  }

  /**
   * Método que cadastra uma nova reserva no hotel.
   * @param reservas Lista de reservas do hotel, que será incrementada.
   * @param acomodacoes Lista de acomodacoes disponiveis no hotel.
   * @param usuario Usuario logado no sistema.
   * @param tipoAcomodacoesCadastradas Lista de tipos de acomodacoes cadastradas no hotel.
   * @param hospedes Lista de hospedes do hotel.
   */
  public static void cadastrarReserva(List<Reserva> reservas,
                                      List<Acomodacao> acomodacoes, Pessoa usuario,
                                      List<TipoAcomodacao> tipoAcomodacoesCadastradas,
                                      List<Hospede> hospedes) {
    if (usuario instanceof Funcionario funcionario) {
      String title = "Cadastrar reserva";

      System.out.println(acomodacoes.size());

      Object []descricoesTipoAcomodacao  = new Object[tipoAcomodacoesCadastradas.size()];
      for (int i = 0; i < tipoAcomodacoesCadastradas.size(); i++) {
        descricoesTipoAcomodacao[i] =
                tipoAcomodacoesCadastradas.get(i).getDescricao();
      }

      // Selecionar o tipo de acomodação
      String tipoAcomodacaoDesejada =
              (String) JOptionPane.showInputDialog(null, "Escolha o tipo da acomodacao desejada", title,
                      JOptionPane.QUESTION_MESSAGE, null, descricoesTipoAcomodacao,
                      descricoesTipoAcomodacao[0]);

      // Filtrar acomodacoes disponiveis
      List<Acomodacao> acomodacoesDisponiveis =
              Designador.getAcomodacoesDisponiveis(tipoAcomodacaoDesejada, acomodacoes);

      while (acomodacoesDisponiveis == null) {
        JOptionPane.showMessageDialog(null, "Nao ha acomodacoes disponiveis para o tipo selecionado", title, JOptionPane.ERROR_MESSAGE);
        tipoAcomodacaoDesejada =
                (String) JOptionPane.showInputDialog(null, "Escolha o tipo da " +
                                "acomodacao desejada", title,
                        JOptionPane.QUESTION_MESSAGE, null, descricoesTipoAcomodacao,
                        descricoesTipoAcomodacao[0]);
        acomodacoesDisponiveis =
                Designador.getAcomodacoesDisponiveis(tipoAcomodacaoDesejada, acomodacoes);
      }

      // Selecionar a acomodação desejada dentre as acomodacoes disponiveis
      Acomodacao acomodacao = (Acomodacao) JOptionPane.showInputDialog(null, "Escolha a acomodacao", title,
              JOptionPane.QUESTION_MESSAGE, null, acomodacoesDisponiveis.toArray(), acomodacoesDisponiveis.getFirst());

        LocalDateTime dataCheckIn = null;
        boolean done = false;
        while (!done) {
          try {
            dataCheckIn = LocalDate.parse(JOptionPane.showInputDialog(null,
                    "Digite a data de check-in", title, JOptionPane.QUESTION_MESSAGE), formatterData).atStartOfDay();
            done = true;
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data invalida", title, JOptionPane.ERROR_MESSAGE);
          }
        }

      LocalDateTime dataCheckOut = null;
        done = false;
        while (!done) {
          try {
            dataCheckOut = LocalDate.parse(JOptionPane.showInputDialog(null,
                    "Digite a data de check-out", title, JOptionPane.QUESTION_MESSAGE), formatterData).atStartOfDay();
            done = true;
          } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data invalida", title, JOptionPane.ERROR_MESSAGE);
          }
        }

        int numAdultos = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero de adultos", title,
                JOptionPane.QUESTION_MESSAGE));
        int numCriancas = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero de criancas", title,
                JOptionPane.QUESTION_MESSAGE));

        if (numAdultos + numCriancas > acomodacao.getTipo().getAdultosComportados() + acomodacao.getTipo().getCriancasComportadas()){
          JOptionPane.showMessageDialog(null, "Numero de hospedes maior que o suportado pela acomodacao", title, JOptionPane.ERROR_MESSAGE);
          JOptionPane.showMessageDialog(null, "Estadia cancelada!", title, JOptionPane.INFORMATION_MESSAGE);
        } else {
          String nomeCartao = JOptionPane.showInputDialog(null, "Digite o nome do cartao", title,
                  JOptionPane.QUESTION_MESSAGE);

          long numeroCartao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero do cartao", title,
                  JOptionPane.QUESTION_MESSAGE));

          int codigoCartao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o codigo do cartao", title,
                  JOptionPane.QUESTION_MESSAGE));

          String dataValidadeCartao = JOptionPane.showInputDialog(null, "Digite a data de validade do cartao", title,
                  JOptionPane.QUESTION_MESSAGE);

          JOptionPane.showMessageDialog(null, "Cadastro do hospede principal", title, JOptionPane.INFORMATION_MESSAGE);
          cadastrarHospede(hospedes, usuario);
          Hospede hospedePrincipal = hospedes.getLast();

          CartaoCredito cartaoCredito = new CartaoCredito(numeroCartao, codigoCartao, nomeCartao, dataValidadeCartao);

          Reserva reserva = new Reserva(dataCheckIn, dataCheckOut, hospedePrincipal, acomodacao, cartaoCredito);

          funcionario.cadastrarReserva(reserva, reservas);

          int numHospedes = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero de hospedes que estaram na reserva: ", title, JOptionPane.QUESTION_MESSAGE));

          for (int i = 0; i < numHospedes; i++) {
            JOptionPane.showMessageDialog(null, "Cadastro do hospede " + (i + 1), title, JOptionPane.INFORMATION_MESSAGE);
            cadastrarHospede(hospedes, usuario);
            reserva.addHospede(hospedes.getLast());
          }

          JOptionPane.showMessageDialog(null, "Reserva cadastrada com sucesso!", title, JOptionPane.INFORMATION_MESSAGE);
      }


    }
  }

  /**
   * Método que cadastra um novo acomodado no hotel.
   * @param usuario Usuario logado no sistema.
   * @param reservas Lista de reservas do hotel.
   * @param acomodados Lista de acomodados do hotel.
   * @param acomodacoesDisponiveis Lista de acomodacoes disponiveis no hotel.
   * @param tiposAcomodacao Lista de tipos de acomodacoes cadastradas no hotel.
   * @param hospedes Lista de hospedes do hotel.
   */
  public static void cadastrarAcomodado(Pessoa usuario, List<Reserva> reservas, List<Acomodado> acomodados, List<Acomodacao> acomodacoesDisponiveis, List<TipoAcomodacao> tiposAcomodacao, List<Hospede> hospedes) {
    // Um acomodado pode ser criado do zero ou a partir de uma reserva

    //Deseja criar um acomodado do zero ou a partir de uma reserva?
    if (usuario.getKey() >= 2){
      boolean acomodaReserva = JOptionPane.showConfirmDialog(null, "Deseja se hospedar a partir de uma reserva?", "Cadastrar acomodado", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

      if (acomodaReserva) {
        String nomeHospedePrincipal = JOptionPane.showInputDialog(null, "Digite o nome do hospede principal", "Cadastrar acomodado", JOptionPane.QUESTION_MESSAGE);

        Reserva reserva = null;
        for (Reserva reserva1 : reservas) {
          if (reserva1.getHospedePrincipal().getNome().equalsIgnoreCase(nomeHospedePrincipal)) {
            for (Hospede hospede : reserva1.getAllHospedes()) {
              hospede.setAcomodado(true);
            }
            reserva = reserva1;
            break;
          }
        }

        if (reserva != null) {
          if (usuario instanceof Funcionario funcionario) {
            funcionario.cadastrarAcomodado(reserva, acomodados, acomodacoesDisponiveis, tiposAcomodacao);
            JOptionPane.showMessageDialog(null, "Acomodado cadastrado com sucesso", "Cadastrar acomodado", JOptionPane.INFORMATION_MESSAGE);
            Remocao.removerReserva(reservas, reserva, usuario);
          }
        } else {
          JOptionPane.showMessageDialog(null, "Reserva nao encontrada", "Cadastrar acomodado", JOptionPane.ERROR_MESSAGE);
        }
      } else {
        // Escolher acomodacao
        Object[] acomodacoes = new Object[acomodacoesDisponiveis.size()];
        for (int i = 0; i < acomodacoesDisponiveis.size(); i++) {
          acomodacoes[i] = acomodacoesDisponiveis.get(i).getNumero();
        }

       int acomodacaoInt = (int) JOptionPane.showInputDialog(null, "Escolha a acomodacao", "Cadastrar acomodado", JOptionPane.QUESTION_MESSAGE, null, acomodacoes, acomodacoes[0]);

        Acomodacao acomodacao = null;

        for (Acomodacao acomodacao1 : acomodacoesDisponiveis) {
          if (acomodacao1.getNumero() == acomodacaoInt) {
            acomodacao = acomodacao1;
            break;
          }
        }

        if (acomodacao != null) {
          LocalDateTime dataCheckIn = LocalDateTime.now();
          boolean done = false;

          LocalDateTime dataCheckOut = null;
          while (!done) {
            try {
              dataCheckOut = LocalDate.parse(JOptionPane.showInputDialog(null,
                      "Digite a data de check-out", "Cadastrar acomodado", JOptionPane.QUESTION_MESSAGE), formatterData).atStartOfDay();
              done = true;
            } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Data invalida", "Cadastrar acomodado", JOptionPane.ERROR_MESSAGE);
            }
          }

          //Cadastro do hospede principal
          JOptionPane.showMessageDialog(null, "Cadastro do hospede principal", "Cadastrar acomodado", JOptionPane.INFORMATION_MESSAGE);
          cadastrarHospede(hospedes, usuario);

          hospedes.getLast().setAcomodado(true);
          Hospede hospedePrincipal = hospedes.getLast();

          // Gerar estadia

          if (usuario instanceof Funcionario funcionario)
            funcionario.cadastrarAcomodado(acomodados, acomodacoesDisponiveis, tiposAcomodacao, dataCheckIn, dataCheckOut, hospedePrincipal, acomodacao);

          int numHospedes = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero de hospedes que estaram na estadia: ", "Cadastrar acomodado", JOptionPane.QUESTION_MESSAGE));

          for (int i = 0; i < numHospedes; i++) {
            JOptionPane.showMessageDialog(null, "Cadastro do hospede " + (i + 1), "Cadastrar acomodado", JOptionPane.INFORMATION_MESSAGE);
            cadastrarHospede(hospedes, usuario);
            acomodados.getLast().addHospede(hospedes.getLast());
          }
        }
      }
    }
  }

  /**
   * Método para cadastrar um item de consumo
   * @param itensConsumoDisponiveis itens de consumo disponiveis
   * @param usuario usuario
   */
  public static void cadastrarItemConsumo(List<ItensConsumo> itensConsumoDisponiveis, Pessoa usuario) {
    if (usuario.getKey() >= 3) {
      String title = "Cadastrar item de consumo";

      int codigo = Integer.parseInt((JOptionPane.showInputDialog(null, "Digite o codigo do item de consumo", title, JOptionPane.QUESTION_MESSAGE)));
      TipoItens tipo = (TipoItens) JOptionPane.showInputDialog(null, "Escolha o tipo do item de consumo", title, JOptionPane.QUESTION_MESSAGE, null, TipoItens.values(), TipoItens.values()[0]);
      String descricao = JOptionPane.showInputDialog(null, "Digite o nome do item de consumo", title, JOptionPane.QUESTION_MESSAGE);
      double preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o preco do item de consumo", title, JOptionPane.QUESTION_MESSAGE));


      ItensConsumo itemConsumo = new ItensConsumo(codigo, tipo, descricao, preco);

      if (usuario instanceof Administrador administrador){
        if (administrador.cadastrarItemConsumo(itemConsumo, itensConsumoDisponiveis)){
          JOptionPane.showMessageDialog(null, "Item de consumo cadastrado com sucesso!");
        } else {
          JOptionPane.showMessageDialog(null, "Item de consumo ja existe!");
        }
      }
    }
  }

  /**
   * Método para cadastrar um tipo de acomodacao
   * @param tiposAcomodacao tipos de acomodacao
   * @param usuario usuario
   */
  public static void cadastrarTipoAcomodacao(List<TipoAcomodacao> tiposAcomodacao, Pessoa usuario) {
    if (usuario.getKey() >= 3) {
      String title = "Cadastrar tipo de acomodacao";

      // Dados necessarios: codigo, nome, descricao, quantidades existentes, diaria, adultos comportados, criancas comportadas

      long codigo = Long.parseLong(JOptionPane.showInputDialog(null, "Digite o codigo do tipo de acomodacao", title, JOptionPane.QUESTION_MESSAGE));
      String nome = JOptionPane.showInputDialog(null, "Digite o nome do tipo de acomodacao", title, JOptionPane.QUESTION_MESSAGE);
      String descricao = JOptionPane.showInputDialog(null, "Digite a descricao do tipo de acomodacao", title, JOptionPane.QUESTION_MESSAGE);
      int quantidadeExistente = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade existente do tipo de acomodacao", title, JOptionPane.QUESTION_MESSAGE));
      double diaria = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a diaria do tipo de acomodacao", title, JOptionPane.QUESTION_MESSAGE));
      int adultosComportados = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de adultos comportados do tipo de acomodacao", title, JOptionPane.QUESTION_MESSAGE));
      int criancasComportadas = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de criancas comportadas do tipo de acomodacao", title, JOptionPane.QUESTION_MESSAGE));


      TipoAcomodacao tipoAcomodacao = new TipoAcomodacao(codigo, nome, descricao, quantidadeExistente, diaria, adultosComportados, criancasComportadas);


      if (usuario instanceof Administrador administrador){
        if (administrador.cadastrarTipoAcomodacao(tipoAcomodacao, tiposAcomodacao)){
          JOptionPane.showMessageDialog(null, "Tipo de acomodacao cadastrado com sucesso!");
        } else {
          JOptionPane.showMessageDialog(null, "Tipo de acomodacao ja existe!");
        }
      }
    }
  }

/**
   * Método para cadastrar uma acomodacao
   * @param acomodacoesDisponiveis acomodacoes disponiveis
   * @param acomodados acomodados
   * @param tiposAcomodacao tipos de acomodacao
   * @param usuario usuario
   */
  public static void cadastrarAcomodacao(List<Acomodacao> acomodacoesDisponiveis, List<Acomodado> acomodados, List<TipoAcomodacao> tiposAcomodacao, Pessoa usuario) {
    if (usuario.getKey() >= 3) {
      String title = "Cadastrar acomodacao";

      //Escolha o tipo de acomodacao
      Object[] tipos = new Object[tiposAcomodacao.size()];
      for (int i = 0; i < tiposAcomodacao.size(); i++) {
        tipos[i] = tiposAcomodacao.get(i).getNome();
      }

      String tipo = (String) JOptionPane.showInputDialog(null, "Escolha o tipo de acomodacao", title, JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);

      // Conveter o tipo para TipoAcomodacao
      TipoAcomodacao tipoAcomodacao = null;
      for (TipoAcomodacao tipoAcomodacao1 : tiposAcomodacao) {
        if (tipoAcomodacao1.getNome().equals(tipo)) {
          tipoAcomodacao = tipoAcomodacao1;
          break;
        }
      }

      int andar = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o andar da acomodacao", title, JOptionPane.QUESTION_MESSAGE));
      int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da acomodacao", title, JOptionPane.QUESTION_MESSAGE));

      if (usuario instanceof Administrador administrador){
        if (administrador.cadastrarAcomodacao(acomodacoesDisponiveis, acomodados, new Acomodacao(andar, numero, tipoAcomodacao))) {
          JOptionPane.showMessageDialog(null, "Acomodacao cadastrada com sucesso!");
        } else {
          JOptionPane.showMessageDialog(null, "Acomodacao ja existe!");
        }
      }
    }
  }

  public static void cadastrarConsumo() {

  }
}
