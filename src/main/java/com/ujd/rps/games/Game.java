package com.ujd.rps.games;

import com.ujd.rps.enums.Choice;
import com.ujd.rps.enums.PlayMode;
import com.ujd.rps.enums.Result;

import java.util.Random;

import static com.ujd.rps.util.Utils.getIntegerInputFromUser;

public abstract class Game {

    private static final String INVALID_MOVE_CHOOSE_AGAIN = "Invalid move! Please choose again.";
    private static final String STARTING_NEW_GAME = "\n0.Rock\n1.Paper\n2.Scissors";
    private static final String ENTER_YOUR_MOVE = "Enter your move(0/1/2): ";
    private static final String WON = " won!";
    private static final String DRAW_STR = "Draw!";
    private static final String INVALID_STATE = "Invalid state! :";
    private static final int BOUND = 3;

    private final PlayMode playMode;

    Game(PlayMode playMode) {
        this.playMode = playMode;
    }

    Choice getUserChoice() {

        Choice selection = null;
        while (selection == null) {
            System.out.println(STARTING_NEW_GAME);
            System.out.print(ENTER_YOUR_MOVE);

            int input = getIntegerInputFromUser();

            if (input >= Choice.ROCK.getValue() && input <= Choice.SCISSORS.getValue()) {
                selection = Choice.fromValue(input);
            } else {
                System.out.println(INVALID_MOVE_CHOOSE_AGAIN);
            }
        }
        return selection;
    }

    public abstract void play();

    void declareWinner(Choice player1, Choice player2, PlayMode playMode) {

        Result winner = checkWinner(player1.getValue(), player2.getValue());

        switch (winner) {
            case PLAYER_ONE: {
                System.out.println(playMode.getPlayerOne() + WON);
                break;
            }
            case PLAYER_TWO: {
                System.out.println(playMode.getPlayerTwo() + WON);
                break;
            }
            case DRAW: {
                System.out.println(DRAW_STR);
                break;
            }
            default:
                throw new IllegalStateException(INVALID_STATE + player1.toString() + " " + player2.toString());
        }
    }

    public static Result checkWinner(int player1, int player2) {
        Choice p1 = Choice.fromValue(player1);
        Choice p2 = Choice.fromValue(player2);

        if (p1 == p2) {
            return Result.DRAW;
        }

        if ((p1 == Choice.ROCK && p2 == Choice.PAPER)
                || (p1 == Choice.PAPER && p2 == Choice.SCISSORS)
                || (p1 == Choice.SCISSORS && p2 == Choice.ROCK)) {

            return Result.PLAYER_TWO;
        } else {
            return Result.PLAYER_ONE;
        }
    }

    Choice getRandomChoice() {
        Random random = new Random();
        return Choice.fromValue(random.nextInt(BOUND));
    }

    PlayMode getPlayMode() {
        return playMode;
    }
}