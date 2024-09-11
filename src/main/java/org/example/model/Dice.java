package org.example.model;

import java.time.Instant;
import java.util.Random;

public class Dice {
    private final int min;
    private final int max;

    private Random random = new Random(Instant.now().toEpochMilli());

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public Dice(int min, int max) {
        this.min = min;
        this.max = max;
    }
    public int rollDice() {
        return random.nextInt(min, max+1);
    }
}
