package med.voll.api.domain.consultas;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    boolean existsByMedicoIdAndData(Long idMedico, @NotNull @Future LocalDateTime data);

    boolean existsBypacienteIdAndDataBetween(@NotNull Long pacienteId, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
}
