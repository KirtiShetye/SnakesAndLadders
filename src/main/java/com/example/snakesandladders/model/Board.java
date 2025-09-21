package com.example.snakesandladders.model;

import java.util.ArrayList;
import java.util.List;

/** Singleton Board*/
class Board {
    private static Board instance;
    /**Board has-a List<Jump>, where Jump is snake or ladder*/
    private final List<Jump> jumps = new ArrayList<>();
    public static final int BOARD_MAX = 100;

    private Board() {
        /**Ladders*/
        jumps.add(new Jump(3, 22));
        jumps.add(new Jump(8, 30));
        jumps.add(new Jump(28, 84));
        jumps.add(new Jump(58, 77));

        /** Snakes*/
        jumps.add(new Jump(95, 56));
        jumps.add(new Jump(87, 24));
        jumps.add(new Jump(62, 19));
        jumps.add(new Jump(48, 10));
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    /**
     * Checks all jumps (snakes or ladders) for the given position and
     * returns position after taking jump.
     * Handled edge cases such as:
     *   - The tail of a snake is the start of a ladder
     *   - The top of a ladder is the head of a snake
     * The loop runs until no jump is encountered or MAX_ITER limit is reached.
     */
    public int applyJump(int pos) {
        int iterations = 0;
        //MAX_ITER is used to prevent infinite loop if bottom of ladder is tail of snake and
        //top of ladder is head of snake
        final int MAX_ITER = 10;
        while (iterations < MAX_ITER) {
            boolean jumped = false;
            for (Jump jump : jumps) {
                if (jump.getStart() == pos) {
                    pos = jump.getEnd();
                    jumped = true;
                    break; // apply only one jump at a time
                }
            }
            if (!jumped)
                break; // no snake or ladder present at pos
            iterations++;
        }
        return pos;
    }
}
