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
        Scanner sc=new Scanner(System.in);
        while(position< Board.BOARD_MAX) {

            System.out.print("Enter current position(range-0 to 99),dice roll(range-1 to 6) (e.g., 0,4) or 'exit' to terminate the game: ");

            String op=sc.nextLine();
            if(op.equals("exit")) {
                return;
            }
            String[] array=op.split(",");
            //sc.close();
            int currentPosition=Integer.valueOf(array[0]);
            int diceCount=Integer.valueOf(array[1]);
            if (currentPosition < 0 || currentPosition > Board.BOARD_MAX || diceCount < 1 || diceCount > 6) {
                System.out.println("Invalid input. Position: 0–100, Dice: 1–6");
                continue;
            }

            position = gameService.checkForSnakeOrLadder(currentPosition,diceCount);
            System.out.println("New position : " +position);


            /**Winning condition*/
            if(position==Board.BOARD_MAX) {
                System.out.println("Yay!! You won!!");
                return;
            }

        }
        sc.close();
        return;

    }
}
