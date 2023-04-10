package com.microsservicos.ada.Album.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Slot {
    @Id
    private UUID id;
    private String albumId;
    private String customDescription;
    private int position;
}
