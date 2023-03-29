package ada.projeto.arquitetura.figurinhas.controller;

import ada.projeto.arquitetura.figurinhas.model.dto.FigurinhaDTO;
import ada.projeto.arquitetura.figurinhas.service.FigurinhaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/figurinhas")
public class FigurinhaController {

    @Autowired
    private FigurinhaService figurinhaService;

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody FigurinhaDTO figurinhaDTO){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(figurinhaService.criar(figurinhaDTO));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editar(
            @RequestBody FigurinhaDTO figurinhaDTO,
            @PathVariable("id") Integer id){
        try{
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
    public ResponseEntity<Object> deletar(@PathVariable("id") Integer id){
        try {
            figurinhaService.deletar(id);
            return ResponseEntity
                    .ok("Figurinha com id " + id + " removida cm sucesso!");
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
    public ResponseEntity<Object> pegaPorId(@PathVariable("id") Integer id){
        try {
            return ResponseEntity.ok(figurinhaService.pegaPorId(id));
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

    @GetMapping
    public ResponseEntity<Object> listar(){
        try {
            return ResponseEntity.ok(figurinhaService.listar());
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    }
}
