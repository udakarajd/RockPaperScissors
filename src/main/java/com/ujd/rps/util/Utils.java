package com.ujd.rps.util;

import java.util.Scanner;

public class Utils {

    public static int getIntegerInputFromUser() {
        String choiceStr = getInputString();

        int input = -1;
        try {
            input = Integer.parseInt(choiceStr);
        } catch (Exception ignored) {

        }
        return input;
    }

    public static String getInputString() {
        Scanner myObj = new Scanner(System.in);
        return myObj.nextLine();
    }
}
