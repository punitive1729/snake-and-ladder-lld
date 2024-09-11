package org.example.model;

import org.example.exceptions.InvalidRunnerException;

public class Ladder extends Runner {
    public Ladder(Cell start, Cell end) throws InvalidRunnerException {
        super(start, end, RunnerType.ladder);
        validate();
    }

    @Override
    public void validate() throws InvalidRunnerException {
        if(this.start.getNumber() >= this.end.getNumber())
            throw new InvalidRunnerException();
    }

    @Override
    public void printMove(String name) {
        System.out.println(name+" got ladder from "+start.getNumber()+" to "+end.getNumber());
    }
}
