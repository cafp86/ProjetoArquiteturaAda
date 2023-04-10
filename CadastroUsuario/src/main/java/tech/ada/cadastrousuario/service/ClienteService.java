package tech.ada.cadastrousuario.service;

import tech.ada.cadastrousuario.model.dto.ClienteDTO;

import java.util.List;
import java.util.UUID;

public interface ClienteService<ClienteDTO> {
    List<ClienteDTO> listarClientes();
    ClienteDTO buscarCliente(UUID id);
    ClienteDTO cadastrarCliente(ClienteDTO clienteDTO);
    ClienteDTO editarCliente(UUID id, ClienteDTO clienteDTO);
    void excluirCliente(UUID id);
}