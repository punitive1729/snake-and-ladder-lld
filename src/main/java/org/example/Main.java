package org.example;

import org.example.exceptions.InvalidBoardException;
import org.example.exceptions.InvalidRunnerException;
import org.example.model.User;
import org.example.services.GameService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws InvalidBoardException, InvalidRunnerException {
        List<User> userList = new ArrayList<>() {{
            add(new User(UUID.randomUUID(), "alice", 0));
            add(new User(UUID.randomUUID(), "bob", 0));
        }};

        GameService gameService = new GameService(100,6, userList);

        while(gameService.getStatus()) {
            try {
                gameService.makeMove();
            } catch (Exception ex) {
                System.out.println("Error: "+ex.getMessage());
            }
        }
    }
}