package med.voll.api.domain.consultas.validacoes;

import jakarta.validation.executable.ValidateOnExecution;
import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consultas.DadosConsulta;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosConsulta dados){
        var dataConsulta = dados.data();

        var agora = LocalDateTime.now();

        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if(diferencaEmMinutos < 30){
            throw new ValidacaoException("Consulta deve ser agendada com antecedência mínima de 30 minutos");
        }
    }
}
