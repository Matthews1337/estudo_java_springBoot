package med.voll.api.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consultas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultasService agenda;

    @Autowired
    private ConsultaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity agendarConsulta(@RequestBody @Valid DadosConsulta dados){
        System.out.println(dados);
        DadosDetalhamentoConsulta consulta = agenda.agendar(dados);
        return ResponseEntity.ok(consulta);
    }


    @DeleteMapping()
    @Transactional
    public ResponseEntity cancelarConsulta(@RequestBody @Valid DadosCancelamentoConsulta dados){
        Consulta consulta = repository.getReferenceById(dados.id());
        var tempoCancelamento = agenda.cancelou24HorasAntesDaConsulta(consulta);
        if(tempoCancelamento){
            consulta.desativar(dados.motivo());
            return ResponseEntity.noContent().build();

        }
        throw new ValidacaoException("Não é possivel cancelar a consulta antes de 24 horas!");
    }

}
