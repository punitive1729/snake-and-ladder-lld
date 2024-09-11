package org.example.model;

import org.example.exceptions.InvalidRunnerException;

public class Snake extends Runner {
    public Snake(Cell start, Cell end) throws InvalidRunnerException {
        super(start, end, RunnerType.snake);
        validate();
    }

    @Override
    public void validate() throws InvalidRunnerException {
        if(this.start.getNumber() <= this.end.getNumber())
            throw new InvalidRunnerException();
    }

    @Override
    public void printMove(String name) {
        System.out.println(name+" bit by snake from "+start.getNumber()+" to "+end.getNumber());
    }
}
