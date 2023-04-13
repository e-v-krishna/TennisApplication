package com.test.tennis.controller;

import com.test.tennis.dto.GameScoreDto;
import com.test.tennis.dto.InitGameDto;
import com.test.tennis.dto.PlayerTypeDto;
import com.test.tennis.service.TennisGameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/** 
* The TennisController program implements an application that
* helps the Tennis Player Umpire score board.
*
* 1. Initiate the Tennis Game
* 2. Record the Score of Player
* 3. Get the Score of Players
*
*
* @author  Venkata Krishna
*/
@RestController
@RequestMapping("/api/tennis")
@RequiredArgsConstructor
@Slf4j
public class TennisController {

    private final TennisGameService tennisGameService;

    @PostMapping("/init")
    @ResponseStatus(HttpStatus.CREATED)
    public void initGame(@Valid @RequestBody InitGameDto initGameDto) {
    	log.info("Tennis Game initialized");
        tennisGameService.initGame(initGameDto);
    }

    @PostMapping("/record/{playerType}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void recordScore(@PathVariable PlayerTypeDto playerType) {
    	log.info(playerType.name()+" Scored");
        tennisGameService.recordScore(playerType);
    }

    @GetMapping("/score")
    public ResponseEntity<GameScoreDto> getScore() {
    	log.info("Retrieve the Score");
        return ResponseEntity.ok(tennisGameService.getScore());
    }
}
