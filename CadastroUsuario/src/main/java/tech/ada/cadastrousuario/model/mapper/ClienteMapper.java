package tech.ada.cadastrousuario.model.mapper;

import org.springframework.stereotype.Component;
import tech.ada.cadastrousuario.model.dto.ClienteDTO;
import tech.ada.cadastrousuario.model.entity.Cliente;

import java.util.List;

@Component
public class ClienteMapper {

    public List<ClienteDTO> parseListDTO(List<Cliente> clientes){
        return clientes.stream().map(cliente -> parseDTO(cliente)).toList();
    }

    public ClienteDTO parseDTO(Cliente cliente){
        return new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEndereco(),
                cliente.getTelefone(),
                cliente.getEmail()
        );
    }

    public List<Cliente> parseList(List<ClienteDTO> clientesDTO){
        return clientesDTO.stream().map(cliente -> parseEntity(cliente)).toList();
    }

    public Cliente parseEntity(ClienteDTO clienteDTO){
        return new Cliente(
                clienteDTO.getId(),
                clienteDTO.getNome(),
                clienteDTO.getCpf(),
                clienteDTO.getEndereco(),
                clienteDTO.getTelefone(),
                clienteDTO.getEmail()
        );
    }
}
