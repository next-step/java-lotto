package step1;

import java.util.Arrays;
import java.util.Scanner;

public class UserInput {
    private static final int ZERO = 0;
    private static final int TWO = 2;
    final static String DELIMITER = ",|:";
    final static int LENGTH_ONE = 1;

    static String getUserInput() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (validateInputNUll(input)) return "0";
        if (validateInputOneNumber(input)) return input;
        validateInputNegative(input.split(DELIMITER));
        if (isCustomDelimiter(input)) {
            input += "\n" + sc.nextLine();
        }
        return input;
    }

    static boolean validateInputNUll(String input) {
        if (input == null || input.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean validateInputOneNumber(String input) {
        if (input.length() == LENGTH_ONE) {
            return true;
        }
        return false;
    }

    static void validateInputNegative(String[] inputs) {
        boolean isAllPositiveValue = Arrays.stream(inputs)
                .map(Integer::parseInt)
                .allMatch(element -> element >= ZERO);

        if (!isAllPositiveValue) {
            throw new RuntimeException("ERR!!!");
        }
    }

    private static boolean isCustomDelimiter(String input) {
        if (input.substring(ZERO, TWO).equals("//")) {
            return true;
        }
        return false;
    }
}
