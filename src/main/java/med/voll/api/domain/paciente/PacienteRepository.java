package med.voll.api.domain.paciente;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query("""
            SELECT
                p.ativo
            FROM
                Paciente p
            WHERE
                p.id = :pacienteId
            """)
    boolean findAtivoById(Long pacienteId);

    Page<Paciente> findAllByAtivoTrue(Pageable paginacao);
}
