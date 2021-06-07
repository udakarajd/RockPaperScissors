package com.ujd.rps.enums;

public enum PlayMode {
    EXIT, PLAYER_VS_COMPUTER, COMPUTER_VS_COMPUTER;

    private static final String INVALID_PLAY_MODE = "Invalid Play Mode: ";
    private static final String YOU = "You";
    private static final String COMPUTER_1 = "Computer 1";
    private static final String COMPUTER_2 = "Computer 2";
    private static final String COMPUTER = "Computer";
    public static final String EXIT_MODE_DOESN_T_HAVE_PLAYERS = "Exit mode doesn't have players";
    private final int value;

    PlayMode() {
        this.value = ordinal();
    }

    public int getValue() {
        return value;
    }

    public static PlayMode fromValue(int value) throws IllegalArgumentException {
        try {
            return PlayMode.values()[value];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(INVALID_PLAY_MODE + value);
        }
    }

    public String getPlayerOne() {
        if(getValue() == 0)
            throw new IllegalArgumentException(EXIT_MODE_DOESN_T_HAVE_PLAYERS);
        return getValue() == PlayMode.PLAYER_VS_COMPUTER.getValue() ? YOU : COMPUTER_1;
    }

    public String getPlayerTwo() {
        if(getValue() == 0)
            throw new IllegalArgumentException(EXIT_MODE_DOESN_T_HAVE_PLAYERS);
        return getValue() == PlayMode.PLAYER_VS_COMPUTER.getValue() ? COMPUTER : COMPUTER_2;
    }
}