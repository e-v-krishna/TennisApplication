package com.test.tennis.service;

import com.test.tennis.dto.GameScoreDto;
import com.test.tennis.dto.InitGameDto;
import com.test.tennis.dto.PlayerTypeDto;

public interface TennisGameService {
    void initGame(InitGameDto initGameDto);

    GameScoreDto getScore();

    void recordScore(PlayerTypeDto playerTypeDto);
}
