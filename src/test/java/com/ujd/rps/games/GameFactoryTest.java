package com.ujd.rps.games;

import com.ujd.rps.enums.PlayMode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameFactoryTest {

    @Test
    void getGame() {
        Assertions.assertTrue(GameFactory.getGame(PlayMode.PLAYER_VS_COMPUTER) instanceof PlayerVsComputerGame, "Expected PlayerVsComputerGame ");
        Assertions.assertTrue(GameFactory.getGame(PlayMode.COMPUTER_VS_COMPUTER) instanceof ComputerVsComputerGame, "Expected ComputerVsComputerGame instance");

        Exception exp = null;
        try {
            GameFactory.getGame(PlayMode.EXIT);
        } catch (Exception e) {
            exp = e;
        }
        Assertions.assertTrue(exp != null && exp instanceof IllegalArgumentException);
    }
}