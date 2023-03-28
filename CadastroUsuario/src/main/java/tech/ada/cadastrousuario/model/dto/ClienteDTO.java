package tech.ada.cadastrousuario.model.dto;


import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private UUID id;
    private String nome;

    @CPF(message="CPF com formato invalido.")
    private String cpf;
    private String endereco;
    private String telefone;

    @Email(message ="Email invalido")
    private String email;
}
