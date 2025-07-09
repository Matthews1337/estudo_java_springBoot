package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull // não é @NotBlank por que nao e uma string e sim um ENUM
        Especialidade especialidade,

        @NotNull
        @Valid // necessario pois precisar dizer para o bean validation que vai ser necessario validar essa DTO
        DadosEndereco endereco) {
}
