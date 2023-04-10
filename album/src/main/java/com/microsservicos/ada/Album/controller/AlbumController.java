package com.microsservicos.ada.Album.controller;

import java.net.http.HttpTimeoutException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.microsservicos.ada.Album.dto.AlbumDTO;
import com.microsservicos.ada.Album.model.Album;
import com.microsservicos.ada.Album.service.AlbumService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/album/")
public class AlbumController {

    private AlbumService service;

    @Autowired
    public AlbumController(AlbumService service) {
        this.service = service;
    }
    @GetMapping("/")
    public ResponseEntity getAll() {
       try {
           List<Album> albuns = service.obterTodosAlbuns();
           return ResponseEntity.ok(albuns);
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable String id) {
        try {
            Optional<Album> album = service.obterAlbumPorId(id);

            if(album.isPresent()) {
                return ResponseEntity.ok(album.get());
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/")
    public ResponseEntity create(@RequestBody AlbumDTO album) {
        try {
            UUID id = service.criarAlbum(new Album(album));
            return ResponseEntity.ok(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> edit(@PathVariable int id, @RequestBody String album) {
        return ResponseEntity.ok("album id: " + Integer.toString(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return ResponseEntity.ok("deleted id: " + Integer.toString(id));
    }
}
