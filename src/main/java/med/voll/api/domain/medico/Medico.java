package med.voll.api.domain.medico;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.Endereco;

@Entity
@Table(name = "medicos")
//lomobk
@Getter // gera os metodos getter's automaticamente sem poluir visualmente a classe
@NoArgsConstructor // gera automaticamente o constructor padrao da classe 'public Medico(){}' sem poluir a classe
@AllArgsConstructor // gera automaticamente o constructor com todos os parametros possiveis sem poluir a classe
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    private boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded //considera que os campos da classe endereco fazem parte da tabela de médicos
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }

    public void desativar() {
        this.ativo = false;
    }

    public Long getId() {
        return id;
    }


}
