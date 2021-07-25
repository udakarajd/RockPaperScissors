package com.ujd.rps.games;

import com.ujd.rps.enums.Choice;
import com.ujd.rps.enums.PlayMode;
import com.ujd.rps.enums.Result;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    @Test
    void checkWinner() {

        assertEquals(Result.PLAYER_TWO, Game.checkWinner(0, 1), "Invalid output");
        assertEquals(Result.PLAYER_TWO, Game.checkWinner(1, 2), "Invalid output");
        assertEquals(Result.PLAYER_TWO, Game.checkWinner(2, 0), "Invalid output");

        assertEquals(Result.PLAYER_ONE, Game.checkWinner(1, 0), "Invalid output");
        assertEquals(Result.PLAYER_ONE, Game.checkWinner(2, 1), "Invalid output");
        assertEquals(Result.PLAYER_ONE, Game.checkWinner(0, 2), "Invalid output");

        assertEquals(Game.checkWinner(0, 0), Result.DRAW, "Invalid output");
        assertEquals(Game.checkWinner(1, 1), Result.DRAW, "Invalid output");
        assertEquals(Game.checkWinner(2, 2), Result.DRAW, "Invalid output");
    }

    @Test
    void getRandomChoice() {
        Game game = new ComputerVsComputerGame(PlayMode.COMPUTER_VS_COMPUTER);

        int value1 = game.getRandomChoice().getValue();
        assertTrue(value1 >= Choice.ROCK.getValue() && value1 <= Choice.SCISSORS.getValue());
        int value2 = game.getRandomChoice().getValue();
        assertTrue(value2 >= Choice.ROCK.getValue() && value2 <= Choice.SCISSORS.getValue());
        int value3 = game.getRandomChoice().getValue();
        assertTrue(value3 >= Choice.ROCK.getValue() && value3 <= Choice.SCISSORS.getValue());
    }
}