package Util;

import java.util.Arrays;

public class CheckInput {
    private static final String[] OPERATORS = {"+", "-", "*", "/"};
    public static boolean isOperator(String input) {
        return Arrays.asList(OPERATORS).contains(input);
    }

    public static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
