package com.test.tennis.dto;

import com.test.tennis.model.Player;

public record GameScoreDto(Player firstPlayer, Player secondPlayer, String score) {
}
