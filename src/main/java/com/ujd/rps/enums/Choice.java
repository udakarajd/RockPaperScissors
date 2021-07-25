package com.ujd.rps.enums;

public enum Choice {
    ROCK, PAPER, SCISSORS;

    private static final String INVALID_CHOICE = "Invalid choice: ";
    final int value;

    Choice() {
        this.value = ordinal();
    }

    public static Choice fromValue(int value) throws IllegalArgumentException {
        try {
            return Choice.values()[value];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(INVALID_CHOICE + value);
        }
    }

    public int getValue() {
        return value;
    }
}
