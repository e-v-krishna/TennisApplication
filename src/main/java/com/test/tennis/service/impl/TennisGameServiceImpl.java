package com.test.tennis.service.impl;

import com.test.tennis.dto.GameScoreDto;
import com.test.tennis.dto.PlayerTypeDto;
import com.test.tennis.exception.GameNotInitException;
import com.test.tennis.exception.IllegalPlayerTypeException;
import com.test.tennis.service.TennisGame;
import com.test.tennis.service.TennisGameService;
import com.test.tennis.dto.InitGameDto;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TennisGameServiceImpl implements TennisGameService {

    private TennisGame tennisGame;

    @Override
    public void initGame(InitGameDto initGameDto) {
        tennisGame = new TennisGame(initGameDto.firstPlayerName(), initGameDto.secondPlayerName());
    }

    @Override
    public GameScoreDto getScore() {
        validateGameInitialized();

        return new GameScoreDto(tennisGame.getFirstPlayer(), tennisGame.getSecondPlayer(), tennisGame.getScore());
    }

    @Override
    public void recordScore(PlayerTypeDto playerTypeDto) {
        validateGameInitialized();

        switch (playerTypeDto) {
            case PLAYER1 -> tennisGame.firstPlayerWin();
            case PLAYER2 -> tennisGame.secondPlayerWin();
            default -> throw new IllegalPlayerTypeException("Unexpected value: " + playerTypeDto);
        }
    }

    private void validateGameInitialized() {
        if(Objects.isNull(this.tennisGame))
            throw new GameNotInitException();
    }
}
