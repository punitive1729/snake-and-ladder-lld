package org.example.model;

import org.example.exceptions.InvalidRunnerException;

public abstract class Runner {
    protected final Cell start;
    protected final Cell end;

    public Cell getStart() {
        return start;
    }

    public Cell getEnd() {
        return end;
    }

    public RunnerType getRunnerType() {
        return runnerType;
    }

    protected final RunnerType runnerType;
    public Runner(Cell start, Cell end, RunnerType runnerType) {
        this.start = start;
        this.end = end;
        this.runnerType = runnerType;
    }

    public abstract void validate() throws InvalidRunnerException;
    public abstract void printMove(String name);
}
