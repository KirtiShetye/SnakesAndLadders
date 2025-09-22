package com.example.snakesandladders.controller;

import com.example.snakesandladders.model.Board;
import com.example.snakesandladders.service.GameService;

import java.util.Scanner;

public class GameController {

    GameService gameService;
    int position;
    public GameController() {
        this.gameService = new GameService();
        this.position = 0;
    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        while(position < Board.BOARD_MAX) {
            System.out.print("Enter current position(range-0 to 99),dice roll(range-1 to 6) (e.g., 0,4) or 'exit' to terminate the game: ");
            String op = sc.nextLine();
            if ("exit".equalsIgnoreCase(op.trim())) {
                System.out.println("Game terminated successfully");
                return;
            }
            int currentPosition;
            int diceCount;
            try{
                String[] array = op.split(",");
                currentPosition = Integer.valueOf(array[0]);
                diceCount = Integer.valueOf(array[1]);
            }catch(Exception e){
                System.out.println("Please enter position: 0-100, diceCount: 1-6 or exit to terminate");
                continue;
            }
            boolean isValidInput = validateInput(currentPosition, diceCount);
            if(!isValidInput) {
                System.out.println("Invalid input. Valid -> Position: 0–100, Dice: 1–6");
                continue;
            }
            position = gameService.calculateNewPosition(currentPosition, diceCount);
            //Winning condition
            if(position == Board.BOARD_MAX) {
                System.out.println("Yay!! You won!!");
                return;
            }
            System.out.println("New position : " +position);
        }

        sc.close();
        return;
    }

    public boolean validateInput(int currentPosition, int diceCount) {
        if (currentPosition < 0 || currentPosition > Board.BOARD_MAX || diceCount < 1 || diceCount > 6)
            return false;
        return true;
    }
}
