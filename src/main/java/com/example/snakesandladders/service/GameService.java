package com.example.snakesandladders.service;

import com.example.snakesandladders.model.Board;

public class GameService {

    private final Board board;
    public GameService(){
        this.board = Board.getInstance();
    }

    public int checkForSnakeOrLadder(int position, int diceCount) {
        int newPosition=position+diceCount;
        if(newPosition > Board.BOARD_MAX) {
            System.out.println("New position range exceeds maximum");
            return position;
        }
        else if(newPosition < Board.BOARD_MAX) {
            return board.applyJump(newPosition);
        }
        else{
            return Board.BOARD_MAX;
        }
    }
}
