package com.example.snakesandladders;

import com.example.snakesandladders.controller.GameController;

public class snakesAndLaddersApp {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}
