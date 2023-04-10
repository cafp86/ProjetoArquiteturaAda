package com.microsservicos.ada.Album.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.microsservicos.ada.Album.model.Album;
import com.microsservicos.ada.Album.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AlbumService {

    private AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> obterTodosAlbuns() {
        return albumRepository.findAll();
    }

    public Optional<Album> obterAlbumPorId(String id) throws IllegalArgumentException, Exception{
        return albumRepository.findById(UUID.fromString(id));
    }

    public UUID criarAlbum(Album album) throws Exception {
        Album albumCriado = albumRepository.save(album);
        return albumCriado.getId();
    }





}
