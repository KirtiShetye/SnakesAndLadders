package com.example.snakesandladderstest.modeltest;

import com.example.snakesandladders.model.Board;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BoardTest {

    public static Board board;
    @BeforeAll
    public static void setUp() {
        board=Board.getInstance();
    }

    @Test
    public void applyJumpWithoutSnakeOrLadder() {
        int position=10;
        int actual = board.applyJump(position);
        int expected = 10;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void applyJumpWithSnake() {
        int position=87;
        //snake from 87->24
        int actual = board.applyJump(position);
        int expected = 24;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void applyJumpWithLadder() {
        int position=56;
        //snake from 56->77
        int actual = board.applyJump(position);
        int expected = 77;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void applyJumpWithLadderAndSnake() {
        int position=8;
        //ladder from 8->30 and snake from 30->19
        int actual = board.applyJump(position);
        int expected = 19;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void applyJumpWithSnakeAndLadder() {
        int position=95;
        //snake from 95->56 and ladder from 56->77
        int actual = board.applyJump(position);
        int expected = 77;
        Assertions.assertEquals(expected, actual);
    }
}
