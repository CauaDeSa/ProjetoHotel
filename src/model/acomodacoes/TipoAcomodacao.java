package model.acomodacoes;

// Definição da classe TipoAcomodacao
public class TipoAcomodacao {

  // Atributos da classe
  long codigo;                   // Código identificador do tipo de acomodação
  String nome;                  // Nome do tipo de acomodação
  String descricao;             // Descrição do tipo de acomodação
  int quantidadeExistente;      // Quantidade existente desse tipo de acomodação
  int quantidadeDisponivel;     // Quantidade disponível desse tipo de acomodação
  double valorDiaria;           // Valor da diária para esse tipo de acomodação
  int adultosComportados;       // Número de adultos que podem ser acomodados
  int criancasComportadas;      // Número de crianças que podem ser acomodadas

  // Construtor da classe TipoAcomodacao que recebe parâmetros para inicializar os atributos
  public TipoAcomodacao(long codigo, String nome, String descricao, int quantidadeExistente, double valorDiaria,
                        int adultosComportados, int criancasComportadas) {
    this.codigo = codigo;
    this.nome = nome;
    this.descricao = descricao;
    this.quantidadeExistente = quantidadeExistente;
    this.quantidadeDisponivel = quantidadeExistente;
    this.valorDiaria = valorDiaria;
    this.adultosComportados = adultosComportados;
    this.criancasComportadas = criancasComportadas;
  }

  // Métodos para obter os valores dos atributos
  public long getCodigo() {
    return codigo;
  }

  public String getNome() {
    return nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public int getQuantidadeExistente() {
    return quantidadeExistente;
  }

  public double getDiaria() {
    return valorDiaria;
  }

  public int getAdultosComportados() {
    return adultosComportados;
  }

  public int getCriancasComportadas() {
    return criancasComportadas;
  }

  public int getQuantidadeDisponivel() {
    return quantidadeDisponivel;
  }

  public void addQuantidadeDisponivel() {
    quantidadeDisponivel -= 1;
  }

  // Método para obter o próprio objeto TipoAcomodacao
  public TipoAcomodacao getTipo() {
    return this;
  }

  @Override
    public String toString() {
        return "TipoAcomodacao{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidadeExistente=" + quantidadeExistente +
                ", valorDiaria=" + valorDiaria +
                ", adultosComportados=" + adultosComportados +
                ", criancasComportadas=" + criancasComportadas +
                '}';
    }
}
