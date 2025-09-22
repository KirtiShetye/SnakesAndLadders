package com.example.snakesandladderstest.controllertest;

import com.example.snakesandladders.controller.GameController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GameControllerTest {

    public static GameController gameController;
    @BeforeAll
    public static void setUp(){
        gameController = new GameController();
    }

    @Test
    public void validateInputValid(){
        int currentPosition = 14;
        int diceCount = 4;
        Assertions.assertTrue(gameController.validateInput(currentPosition,diceCount));
    }

    @Test
    public void validateInputInValidCurrentPosition(){
        int currentPosition = 114;
        int diceCount = 4;
        Assertions.assertFalse(gameController.validateInput(currentPosition,diceCount));
    }

    @Test
    public void validateInputInValidDiceCount(){
        int currentPosition = 14;
        int diceCount = 7;
        Assertions.assertFalse(gameController.validateInput(currentPosition,diceCount));
    }
}
