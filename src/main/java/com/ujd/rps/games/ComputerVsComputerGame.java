package com.ujd.rps.games;

import com.ujd.rps.enums.Choice;
import com.ujd.rps.enums.PlayMode;

public class ComputerVsComputerGame extends Game {

    private static final String COMPUTER_1_CHOSE = "Computer 1 chose: ";
    private static final String COMPUTER_2_CHOSE = "Computer 2 chose: ";
    private static final String RESULT_STR = "Result: ";

    public ComputerVsComputerGame(PlayMode playMode) {
        super(playMode);
    }

    @Override
    public void play() {

        Choice c1Choice = getRandomChoice();
        System.out.println(COMPUTER_1_CHOSE + c1Choice.toString());
        Choice c2Choice = getRandomChoice();
        System.out.println(COMPUTER_2_CHOSE + c2Choice.toString());
        System.out.print(RESULT_STR);

        declareWinner(c1Choice, c2Choice, getPlayMode());
    }
}
