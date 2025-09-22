package com.example.snakesandladderstest.servicetest;

import com.example.snakesandladders.model.Board;
import com.example.snakesandladders.service.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GameServiceTest {

    public static GameService gameService;

    @BeforeAll
    public static void init() {
        gameService = new GameService();
    }

    @Test
    public void testGameServiceWithinRange() {
        int currentPosition = 20;
        int diceCount = 7;
        int actual = gameService.calculateNewPosition(currentPosition,diceCount);
        int expected = 27;
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testGameServiceExceedsMaximumRange() {
        int currentPosition = 99;
        int diceCount = 5;
        int actual = gameService.calculateNewPosition(currentPosition,diceCount);
        int expected = 99;
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testGameServiceWin() {
        int currentPosition = 99;
        int diceCount = 1;
        int actual = gameService.calculateNewPosition(currentPosition,diceCount);
        int expected = 100;
        Assertions.assertEquals(expected,actual);
    }

}
