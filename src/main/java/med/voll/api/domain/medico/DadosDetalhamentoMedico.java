package med.voll.api.domain.medico;

import med.voll.api.domain.endereco.Endereco;

public record DadosDetalhamentoMedico(Long id, String nome, String crm, String telefone, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoMedico(Medico medico){
        this(medico.getId(),medico.getNome(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
