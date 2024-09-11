package org.example.model;

import java.util.UUID;

public class Cell {
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private UUID id;
    private int number;

    public Cell(UUID id, int number) {
        this.id = id;
        this.number = number;
    }
}
