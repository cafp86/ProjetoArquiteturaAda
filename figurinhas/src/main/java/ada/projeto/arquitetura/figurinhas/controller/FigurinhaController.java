package ada.projeto.arquitetura.figurinhas.controller;
import ada.projeto.arquitetura.figurinhas.model.dto.FigurinhaDTO;
import ada.projeto.arquitetura.figurinhas.service.FigurinhaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/figurinhas")
public class FigurinhaController {

    @Autowired
    private FigurinhaService figurinhaService;

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody FigurinhaDTO figurinhaDTO) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(figurinhaService.criar(figurinhaDTO));

        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }

    @PostMapping("batch")
    public ResponseEntity<Object> criarVarias(@RequestBody List<FigurinhaDTO> figurinhas) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(figurinhaService.criarVarias(figurinhas));

        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editar(
            @RequestBody FigurinhaDTO figurinhaDTO,
            @PathVariable("id") Integer id) {

        try {
            return ResponseEntity.ok(figurinhaService.editar(figurinhaDTO, id));

        } catch (EntityNotFoundException ex) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ex.getMessage());

        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable("id") Integer id) {

        try {
            figurinhaService.deletar(id);
            return ResponseEntity
                    .ok("Figurinha com id " + id + " removida com sucesso!");

        } catch (EntityNotFoundException ex) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ex.getMessage());

        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> pegarPorId(@PathVariable("id") Integer id) {

        try {
            return ResponseEntity.ok(figurinhaService.pegarPorId(id));

        } catch (EntityNotFoundException ex) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(ex.getMessage());

        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Object> listar() {

        try {
            return ResponseEntity.ok(figurinhaService.listar());

        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    }

    @GetMapping("/album/{id}")
    public ResponseEntity<Object> listarPorAlbum(@PathVariable("id") Integer albumId) {

        try {
            return ResponseEntity.ok(figurinhaService.listarPorAlbum(albumId));

        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    }

}
