package com.microsservicos.ada.Album.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;
import java.util.UUID;

@Entity
public class Usuario {

    @Id
    private UUID id;
    private List<String> Albuns;
}
