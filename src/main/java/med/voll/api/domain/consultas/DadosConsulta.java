package med.voll.api.domain.consultas;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.Especialidade;

import java.time.LocalDateTime;

public record DadosConsulta (

        Long idMedico,
        @NotNull
        Long idPaciente,

        @NotNull
        @Future
        LocalDateTime data, // podemos alterar o formato com @JsonFormat(pattern = "dd/MM/yyyy HH:mm")


        Especialidade especialidade
){
}
