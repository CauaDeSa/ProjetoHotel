package model.acomodacoes;

import model.pessoas.Funcionario;
import model.pessoas.Hospede;

import java.time.LocalDateTime;

public class Acomodado extends ReservaAbstract {
  private Funcionario funcionarioResponsavel;

  public Acomodado(LocalDateTime checkIn, LocalDateTime checkOut, Hospede hospedePrincipal, Acomodacao acomodacao, int numeroAcomodacao, int andar, Funcionario funcionarioResponsavel) {
    super(checkIn, checkOut, hospedePrincipal, acomodacao);
    this.funcionarioResponsavel = funcionarioResponsavel;
  }
}