package com.ujd.rps.games;

import com.ujd.rps.enums.Choice;
import com.ujd.rps.enums.PlayMode;

public class PlayerVsComputerGame extends Game {

    private static final String YOU_CHOSE = "You chose: ";
    private static final String COMPUTER_CHOSE = "Computer chose: ";
    private static final String RESULT_STR = "Result: ";

    public PlayerVsComputerGame(PlayMode playMode) {
        super(playMode);
    }

    @Override
    public void play() {

        Choice pChoice = getUserChoice();
        System.out.println(YOU_CHOSE + pChoice.toString());
        Choice cChoice = getRandomChoice();
        System.out.println(COMPUTER_CHOSE + cChoice.toString());
        System.out.print(RESULT_STR);

        declareWinner(pChoice, cChoice, getPlayMode());
    }

}
