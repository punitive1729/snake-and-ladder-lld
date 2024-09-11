package org.example.services;

import org.example.exceptions.*;
import org.example.model.*;

import java.util.*;

public class GameService {
    private Board board;
    private Dice dice;
    private Boolean status;
    private Queue<Participant> participants = new LinkedList<>();

    public Board getBoard() {
        return board;
    }

    public Dice getDice() {
        return dice;
    }

    public Boolean getStatus() {
        return status;
    }

    public Queue<Participant> getParticipants() {
        return participants;
    }

    public List<Participant> getRanking() {
        return ranking;
    }

    private List<Participant> ranking = new ArrayList<>();
    public GameService(int size, int maxRollPossible, List<User> users) throws InvalidBoardException, InvalidRunnerException {
        this.board = new Board(size);
        this.dice = new Dice(1, maxRollPossible);
        this.status = true;
        for(User user: users)
            this.participants.add(new Participant(UUID.randomUUID(), user, this.board.getCell(0)));
    }

    public synchronized void makeMove() throws GameFinishedException {
        if(!this.status || this.participants.isEmpty())
            throw new GameFinishedException();

        // take current participant
        Participant participant = participants.poll();

        int currentPosition = participant.getCurrentPosition().getNumber();
        int diceRoll = dice.rollDice();
        // roll dice
        int nextPosition = currentPosition + diceRoll;

        if(nextPosition >= board.getSize()) {
            // Move is wasted so no movement allowed and next player needs to make move
            participants.add(participant);
            return;
        }

        while(true) {
            // get next cell
            Cell nextCell = board.getCell(nextPosition);
            Runner runner = board.getRunner(nextCell);

            if(Objects.isNull(runner)) {
                participant.setCurrentPosition(nextCell);
                break;
            }

            // if there is a runner then next cell will be pointed by runner
            nextPosition = runner.getEnd().getNumber();
            runner.printMove(participant.getUser().getName());
        }

        System.out.println(participant.getUser().getName()+" moved from originalPosition "+currentPosition+" with dice roll "+ diceRoll+" to "+nextPosition);

        if(participant.getCurrentPosition().getNumber()==(board.getSize()-1)) {
            System.out.println(participant.getUser().getName()+" has finished the game");
            ranking.add(participant);
        } else {
            participants.add(participant);
        }

        if(participants.size()==1) {
            status = false;
            ranking.add(participants.poll());
            printRanking();
        }
    }

    public void printRanking() {
        System.out.println("\n\n\nRank \t\t\t\t\t\t\t\t\t Name");
        for(int i=1;i<=ranking.size();++i)
            System.out.println(i+"\t\t\t\t\t\t\t"+ranking.get(i-1).getUser().getName());
    }
}
