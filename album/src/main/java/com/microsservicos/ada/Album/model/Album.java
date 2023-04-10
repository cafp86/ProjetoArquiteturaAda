package com.microsservicos.ada.Album.model;

import com.microsservicos.ada.Album.dto.AlbumDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;
import java.util.UUID;

@Entity
public class Album {
    @Id
    private UUID id;
    private String description;
    private int numberOfSlots;

    public Album() {

    }
    public Album(AlbumDTO dto) {
        this.description = dto.descricao;
        this.numberOfSlots = dto.slots;
        this.id = UUID.randomUUID();
    }

    public String getDescription() {
        return description;
    }
    public int getNumberOfSlots() {
        return numberOfSlots;
    }
    public UUID getId() {
        return id;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setNumberOfSlots(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }


}
