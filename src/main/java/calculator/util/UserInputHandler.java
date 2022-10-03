package calculator.util;

import java.util.Arrays;
import java.util.Scanner;

public class UserInputHandler {
    private static final String[] OPERATOR = {"+", "-", "*", "/"};
    static Scanner scanner = new Scanner(System.in);

    public static boolean checkValidate(String input) {
        if (input == null || input.equals("")) {
            return false;
        }

        String[] splitInputs = input.split(" ");
        if (!hasValidFormat(splitInputs)) {
            return false;
        }

        if (!hasOperationFormat(splitInputs)) {
            return false;
        }

        if (splitInputs.length < 2) {
            return false;
        }

        return true;
    }

    private static boolean hasValidFormat(String[] splitInputs) {
        boolean hasValidFormat = true;
        for (String splitInput : splitInputs) {
            hasValidFormat = checkValidFormat(splitInput) && hasValidFormat;
        }
        return hasValidFormat;
    }

    private static boolean hasOperationFormat(String[] splitInputs) {
        boolean hasOperation = false;
        for (int i = 1; i < splitInputs.length; i += 2) {
            hasOperation = checkOperator(splitInputs[i]) || hasOperation;
        }
        return hasOperation;
    }

    private static boolean checkValidFormat(String splitInput) {
        return checkInteger(splitInput) || checkOperator(splitInput);
    }

    private static boolean checkOperator(String input) {
        return Arrays.asList(OPERATOR).contains(input);
    }

    private static boolean checkInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    public static String scan() {
        return scanner.nextLine();
    }
}
