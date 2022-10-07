package calculator.util;

import calculator.domain.ArithmeticOperation;

import java.util.Arrays;
import java.util.Scanner;

public class UserInputHandler {
    static Scanner scanner = new Scanner(System.in);

    public static boolean checkValidate(String input) {
        if (input == null || input.equals("")) {
            return false;
        }

        String[] splitInputs = input.split(" ");

        if (!hasOperationFormat(splitInputs)) {
            return false;
        }

        if (splitInputs.length < 3) {
            return false;
        }

        return true;
    }

    private static boolean hasOperationFormat(String[] splitInputs) {
        boolean hasOperation = false;
        for (int i = 1; i < splitInputs.length; i += 2) {
            hasOperation = checkOperator(splitInputs[i]) || hasOperation;
        }
        return hasOperation;
    }

    private static boolean checkOperator(String input) {
        return ArithmeticOperation.hasOperation(input);
    }


    public static String scan() {
        return scanner.nextLine();
    }
}
