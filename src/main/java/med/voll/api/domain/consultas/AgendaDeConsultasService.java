package med.voll.api.domain.consultas;


import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consultas.validacoes.ValidadorAgendamentoDeConsulta;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendaDeConsultasService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoDeConsulta> validadores; // O spring injecta automaticamente as classes que herdam da interface!

    public DadosDetalhamentoConsulta agendar(DadosConsulta dados){
        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("id do paciente informado não existe!");
        }
        if(dados.idMedico()!= null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoException("id do médico informado não existe!");
        }

        // Aqui foi aplicado o 'D'do SOLID! Dependency Iversion Principle, que depende de uma abstração e nao de uma implementaçao em específico
        // A classe AgendaDeConsultasService também possui o 'O' Open Close Principle do SOLID, que diz que a classe deve ser aberta para novas extensões e fechada para modificações
        // Cada classe de validação possui também o 'S' Single Reponsibility do SOLID, que diz que uma classe deve ter uma única responsabilidade
        validadores.forEach(v -> v.validar(dados));

        var medico = escolherMedico(dados);
        if(medico == null){
            throw new ValidacaoException("nenhum médico disponível nesta data!");
        }

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var consulta = new Consulta(null, paciente, medico, dados.data(), true, null);
        consultaRepository.save(consulta);
        return new DadosDetalhamentoConsulta(consulta);
    }

    public boolean cancelou24HorasAntesDaConsulta(Consulta consulta){
        var dataConsulta = consulta.getData();
        var dataCancelamento = LocalDateTime.now();
        return dataCancelamento.isBefore(dataConsulta.minusHours(24));
    }

    private Medico escolherMedico(DadosConsulta dados) {

        if(dados.idMedico() != null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }
        if(dados.especialidade() == null){
            throw new ValidacaoException("Especialidade é obrigatória quando o médico não for definido!");
        }
        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }


}
