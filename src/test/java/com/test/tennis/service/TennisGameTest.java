package com.test.tennis.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class TennisGameTest {

    private TennisGame tennisGame;

    private final String firstPlayerName = "Player1";
    private final String secondPlayerName = "Player2";

    @BeforeEach
    public void setup() {
        tennisGame = new TennisGame(firstPlayerName, secondPlayerName);
    }

    @Test
    void shouldReturnLoveAll() {
        String score = tennisGame.getScore();
        assertEquals("0:0", score);
    }

    @Test
    void firstPlayerWinsFirstBall() {
        playersWins(1, 0);
        String score = tennisGame.getScore();

        assertEquals("15:0", score);
    }

    @Test
    void firstPlayerWinsTwoBall() {
        playersWins(2, 0);
        String score = tennisGame.getScore();

        assertEquals("30:0", score);
    }

    @Test
    void firstPlayerWinsThreeBall() {
        playersWins(3, 0);
        String score = tennisGame.getScore();

        assertEquals("40:0", score);
    }

    @Test
    void secondPlayerWinsFirstBall() {
        playersWins(0, 1);
        String score = tennisGame.getScore();

        assertEquals("0:15", score);
    }

    @Test
    void secondPlayerWinsTwoBall() {
        playersWins(0, 2);
        String score = tennisGame.getScore();

        assertEquals("0:30", score);
    }

    @Test
    void secondPlayerWinsThreeBall() {
        playersWins(0, 3);
        String score = tennisGame.getScore();

        assertEquals("0:40", score);
    }

    @Test
    void bothPlayersWinsOneBall() {
        playersWins(1, 1);
        String score = tennisGame.getScore();

        assertEquals("15:15", score);
    }

    @Test
    void bothPlayersWinsTwoBall() {
        playersWins(2, 2);
        String score = tennisGame.getScore();

        assertEquals("30:30", score);
    }

    @Test
    void playersAreDeuce3x3() {
        playersWins(3, 3);
        String score = tennisGame.getScore();

        assertEquals("40:40", score);
    }

    @Test
    void firstPlayerAdv() {
        playersWins(5, 4);
        String score = tennisGame.getScore();

        assertEquals("A:null", score);
    }

    @Test
    void secondPlayerAdv() {
        playersWins(3, 4);
        String score = tennisGame.getScore();

        assertEquals("40:A", score);
    }

    @Test
    void firstPlayerWinTheGame() {
        playersWins(5, 3);
        String score = tennisGame.getScore();

        assertEquals(firstPlayerName + " Win", score);
    }

    @Test
    void secondPlayerWinTheGame() {
        playersWins(3, 5);
        String score = tennisGame.getScore();

        assertEquals(secondPlayerName + " Win", score);
    }

    private void playersWins(int firstPlayerTimes, int secondPlayerTimes) {
        for(int i = 0; i < firstPlayerTimes; i++) {
            tennisGame.firstPlayerWin();
        }

        for(int i = 0; i < secondPlayerTimes; i++) {
            tennisGame.secondPlayerWin();
        }
    }
}
