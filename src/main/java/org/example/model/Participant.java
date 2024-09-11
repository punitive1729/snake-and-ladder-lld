package org.example.model;


import java.util.UUID;

public class Participant {
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public Cell getCurrentPosition() {
        return currentPosition;
    }
    public void setCurrentPosition(Cell currentPosition) {
        this.currentPosition = currentPosition;
    }
    public Participant(UUID id, User user, Cell currentPosition) {
        this.id = id;
        this.user = user;
        this.currentPosition = currentPosition;
    }
    private User user;
    private Cell currentPosition;
}
