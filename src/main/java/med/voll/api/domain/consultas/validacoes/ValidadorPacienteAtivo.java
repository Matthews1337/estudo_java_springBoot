package med.voll.api.domain.consultas.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consultas.DadosConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    PacienteRepository repository;

    public void validar(DadosConsulta dados){

        var pacienteAtivo =  repository.findAtivoById(dados.idPaciente());

        if(!pacienteAtivo){
            throw new ValidacaoException("Paciente não está ativo");
        }
    }
}
