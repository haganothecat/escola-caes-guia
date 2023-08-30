package hkeller.escolacaesguia.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "visita")
public class Visita {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nome_escola", nullable = false)
  private String nomeEscola;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String endereco;

  @Column(nullable = false)
  private String bairro;

  @Column(nullable = false)
  private String cidade;

  @Column(name = "cep")
  private Integer cep;

  @Column(name = "telefone_escola")
  private Integer telefoneEscola;

  @Column(name = "nome_responsave", nullable = false)
  private String nomeResponsavel;

  @Column(name = "telefone_responsavel")
  private Integer telefoneResponsavel;

  @Column(name = "numero_alunos")
  private Integer numeroAlunos;

  @Column(name = "serie_escolar", nullable = false)
  private String serieEscolar;

  @Column(name = "idade_alunos")
  private Integer idadeAlunos;

  @Column(name = "texto_objetivo", nullable = false)
  private String textoObjetivo;

  @Column(name = "sim_nao")
  private Integer simNao;

  @Column(name = "data_visita")
  private Date dataVisita;

  @Column(name = "hora_visita")
  private Integer horaVisita;

  @Column(name = "informacoes_extras", nullable = false)
  private String informacoesExtras;

}
