package com.test.tennis.service;

import com.test.tennis.model.Player;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {

    private final Player firstPlayer;
    private final Player secondPlayer;

    private static final Map<Integer, String> SCORES = new HashMap<>();

    static {
        SCORES.put(0, "0");
        SCORES.put(1, "15");
        SCORES.put(2, "30");
        SCORES.put(3, "40");
    }

    public TennisGame(String firstPlayerName, String secondPlayerName) {
        this.firstPlayer = Player.builder().name(firstPlayerName).build();
        this.secondPlayer = Player.builder().name(secondPlayerName).build();
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public String getScore() {
        if(isDeuce()) {           
        	 return SCORES.get(firstPlayer.getScore()) + ":" + SCORES.get(secondPlayer.getScore());
        }

		

       String highestPlayerName = getHighestPlayerName();
        if(firstPlayer.getScore() > 3 || secondPlayer.getScore() > 3) {
            if(hasAdvantage()) {             
            	return firstPlayer.getScore() > secondPlayer.getScore() ? "A:"+SCORES.get(secondPlayer.getScore()):SCORES.get(firstPlayer.getScore())+":A";               
            }

            if(hasWinner()) {
                return highestPlayerName + " Win";
            }
        }

        return SCORES.get(firstPlayer.getScore()) + ":" + SCORES.get(secondPlayer.getScore());
    }

    public void firstPlayerWin() {
        firstPlayer.increaseScore();
    }

    public void secondPlayerWin() {
        secondPlayer.increaseScore();
    }

    private boolean isDeuce() {
        return firstPlayer.getScore() == secondPlayer.getScore() && firstPlayer.getScore() >= 3;
    }

    private boolean hasAdvantage() {
        return Math.abs(firstPlayer.getScore() - secondPlayer.getScore()) == 1;
    }

    private boolean hasWinner() {
        return Math.abs(firstPlayer.getScore() - secondPlayer.getScore()) >= 2;
    }

    private String getHighestPlayerName() {
        return firstPlayer.getScore() > secondPlayer.getScore() ? firstPlayer.getName() : secondPlayer.getName();
    }
}
