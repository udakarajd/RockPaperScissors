package com.ujd.rps.starter;

import com.ujd.rps.enums.PlayMode;
import com.ujd.rps.games.Game;
import com.ujd.rps.games.GameFactory;

import static com.ujd.rps.util.Utils.getInputString;
import static com.ujd.rps.util.Utils.getIntegerInputFromUser;

public class GameStarter {

    private static final int EXIT_CODE = 0;
    private static final String INVALID_CHOICE_CHOOSE_AGAIN = "Invalid choice! Please choose again.";
    private static final String GOOD_BYE = "Thank you for playing. See you soon. Good Bye!";
    private static final String PLAY_AGAIN_Y_N = "\nPlay again? (y/n)";
    private static final String YOU_CHOSE = "You chose ";

    private static PlayMode playMode;

    public void startGame() {

        playMode = null;

        while (playMode == null) {
            showMenu();
            geModeFromUser();
        }

        endIfExit(playMode.getValue());

        System.out.println(YOU_CHOSE + playMode.toString());

        Game game;
        do {
            game = GameFactory.getGame(playMode);
            game.play();
        } while (isPlayAgain());
    }

    private boolean isPlayAgain() {
        System.out.print(PLAY_AGAIN_Y_N);

        String str = getInputString();

        if (str != null && str.equalsIgnoreCase("n")) {
            endIfExit(0);
        }

        if (str != null && str.equalsIgnoreCase("y")) {
            return true;
        } else {
            System.out.println(INVALID_CHOICE_CHOOSE_AGAIN);
            return isPlayAgain();
        }
    }

    private void geModeFromUser() {

        int input = getIntegerInputFromUser();

        if (input >= PlayMode.EXIT.getValue() && input <= PlayMode.COMPUTER_VS_COMPUTER.getValue()) {
            playMode = PlayMode.fromValue(input);
        } else {
            System.out.println(INVALID_CHOICE_CHOOSE_AGAIN);
        }
    }


    private void endIfExit(int number) {
        if (number == EXIT_CODE) {
            System.out.println(GOOD_BYE);
            System.exit(0);
        }
    }


    private void showMenu() {
        System.out.println("\n***** Let's play a game of Rock, Paper, Scissors! *****" +
                "\n1. You vs Computer " +
                "\n2. Computer vs Computer" +
                "\n0. Exit Game" );
        System.out.print("\nChoose your option number (1/2/0): ");
    }
}
