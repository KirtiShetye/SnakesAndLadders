package com.example.snakesandladders.model;

import java.util.ArrayList;
import java.util.List;

/** Singleton Board*/
public class Board {
    private static Board instance;
    /**Board has-a List<Jump>, where Jump is snake or ladder*/
    private final List<Jump> jumps = new ArrayList<>();
    public static final int BOARD_MAX = 100;

    private Board() {
        /**Ladders*/
        jumps.add(new Jump(3, 22));
        jumps.add(new Jump(8, 30));
        jumps.add(new Jump(28, 84));
        jumps.add(new Jump(56, 77));

        /** Snakes*/
        jumps.add(new Jump(95, 56));
        jumps.add(new Jump(87, 24));
        jumps.add(new Jump(30, 19));
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
     */
    public int applyJump(int position) {
        while (true) {
            boolean jumped = false;
            for (Jump jump : jumps) {
                if (jump.getStart() == position) {
                    position = jump.getEnd();
                    jumped = true;
                    break; // apply only one jump at a time
                }
            }
            if (!jumped)
                break; // no snake or ladder present at position
        }
        return position;
    }
}
