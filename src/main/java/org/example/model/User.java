package org.example.model;

import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private int points;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public User(UUID id, String name, int points) {
        this.id = id;
        this.name = name;
        this.points = points;
    }
}
