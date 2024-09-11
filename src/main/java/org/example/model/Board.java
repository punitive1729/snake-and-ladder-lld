package org.example.model;

import org.example.exceptions.InvalidBoardException;
import org.example.exceptions.InvalidRunnerException;

import java.util.*;

public class Board {
    private int size;
    private final List<Cell> cells = new ArrayList<>();
    private final Map<Cell, Runner> runners = new HashMap<>();

    public int getSize() {
        return size;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public Map<Cell, Runner> getRunners() {
        return runners;
    }

    public Board(int size) throws InvalidBoardException, InvalidRunnerException {
        if(size<100)
            throw new InvalidBoardException();

        this.size = size;
        for(int i=0;i<size;++i)
            cells.add(new Cell(UUID.randomUUID(), i));

        // make snakes
        runners.put(cells.get(10), new Snake(cells.get(10), cells.get(5)));
        runners.put(cells.get(45), new Snake(cells.get(45), cells.get(23)));
        runners.put(cells.get(65), new Snake(cells.get(65), cells.get(2)));
        runners.put(cells.get(83), new Snake(cells.get(83), cells.get(34)));


        // make ladders
        runners.put(cells.get(7), new Ladder(cells.get(7), cells.get(37)));
        runners.put(cells.get(12), new Ladder(cells.get(12), cells.get(55)));
        runners.put(cells.get(21), new Ladder(cells.get(21), cells.get(85)));
    }
    public Cell getCell(int number) {
        return cells.get(number);
    }
    public Runner getRunner(Cell cell) {
        return runners.get(cell);
    }
}
