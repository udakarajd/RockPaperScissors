package com.ujd.rps.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayModeTest {

    @Test
    void fromValue() {
        assertEquals(PlayMode.EXIT,PlayMode.fromValue(0), "Wrong output");
        assertEquals(PlayMode.PLAYER_VS_COMPUTER,PlayMode.fromValue(1), "Wrong output");
        assertEquals(PlayMode.COMPUTER_VS_COMPUTER,PlayMode.fromValue(2), "Wrong output");
    }

    @Test
    void getPlayerOne() {

        assertEquals("Computer 1",PlayMode.COMPUTER_VS_COMPUTER.getPlayerOne(), "Wrong output");
        assertEquals("You",PlayMode.PLAYER_VS_COMPUTER.getPlayerOne(), "Wrong output");

        Exception exp = null;
        try{
            PlayMode.EXIT.getPlayerOne();
        }catch (Exception e){
            exp = e;
        }
        Assertions.assertTrue(exp!=null && exp instanceof IllegalArgumentException);

    }

    @Test
    void getPlayerTwo() {

        assertEquals("Computer",PlayMode.PLAYER_VS_COMPUTER.getPlayerTwo(), "Wrong output");
        assertEquals("Computer 2",PlayMode.COMPUTER_VS_COMPUTER.getPlayerTwo(), "Wrong output");

        Exception exp2 = null;
        try{
            PlayMode.EXIT.getPlayerTwo();
        }catch (Exception e){
            exp2 = e;
        }
        Assertions.assertTrue(exp2!=null && exp2 instanceof IllegalArgumentException);
    }
}