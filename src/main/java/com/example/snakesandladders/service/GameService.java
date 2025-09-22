package com.example.snakesandladders.service;

import com.example.snakesandladders.model.Board;

public class GameService {

    private final Board board;
    public GameService(){
        this.board = Board.getInstance();
    }

    public int calculateNewPosition(int position, int diceCount) {
        int newPosition = position+diceCount;
        //New position range exceeds maximum
        if(newPosition > Board.BOARD_MAX) {
            return position;
        }
        else if(newPosition == Board.BOARD_MAX){
            return Board.BOARD_MAX;
        }
        else {
            return board.applyJump(newPosition);
        }
    }
}
