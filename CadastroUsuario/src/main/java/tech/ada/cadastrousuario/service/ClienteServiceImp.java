package tech.ada.cadastrousuario.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ada.cadastrousuario.model.dto.ClienteDTO;
import tech.ada.cadastrousuario.model.entity.Cliente;
import tech.ada.cadastrousuario.model.mapper.ClienteMapper;
import tech.ada.cadastrousuario.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteServiceImp implements ClienteService<ClienteDTO>{
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteMapper mapper;

    public List<ClienteDTO> listarClientes(){
        return mapper.parseListDTO(repository.findAll());
    }

    public ClienteDTO buscarCliente(UUID id) {
        Optional<Cliente> clienteOp = repository.findById(id);
        if (clienteOp.isPresent()){
            Cliente cliente = clienteOp.get();
            return mapper.parseDTO(cliente);
        }
        throw new EntityNotFoundException();
    }

    public ClienteDTO cadastrarCliente(@Valid ClienteDTO clienteDTO){
        Cliente cliente = mapper.parseEntity(clienteDTO);
        cliente.setId(null);
        repository.save(cliente);
        return mapper.parseDTO(cliente);
    }

    public ClienteDTO editarCliente(UUID id, ClienteDTO clienteDTO){
        if (repository.existsById(id)){
            Cliente cliente = mapper.parseEntity(clienteDTO);
            cliente.setId(id);
            cliente = repository.save(cliente);
            return mapper.parseDTO(cliente);
        }
        throw new EntityNotFoundException();
    }

    public void excluirCliente(UUID id){
        if(!repository.existsById(id)){
            throw new EntityNotFoundException();
        }
        repository.deleteById(id);
    }
}
