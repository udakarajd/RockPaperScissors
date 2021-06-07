package com.ujd.rps.games;

import com.ujd.rps.enums.PlayMode;

public class GameFactory {

    private static final String INVALID_GAME_MODE = "Invalid game mode!";

    public static Game getGame(PlayMode mode){
        Game game;
        if(mode.equals(PlayMode.COMPUTER_VS_COMPUTER)){
            game = new ComputerVsComputerGame(mode);
        }else if(mode.equals(PlayMode.PLAYER_VS_COMPUTER)){
            game = new PlayerVsComputerGame(mode);
        }else {
            throw new IllegalArgumentException(INVALID_GAME_MODE);
        }
        return game;
    }
}
