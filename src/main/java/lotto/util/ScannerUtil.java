package lotto.util;

import java.util.Scanner;

import static lotto.Messages.WARNING_INTEGER_FORMAT;
import static lotto.Messages.WARNING_NULL_AND_EMPTY;

public class ScannerUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readLine() {
        String stringInput = scanner.nextLine();
        validateNullAndEmpty(isNullOrEmpty(stringInput));
        return stringInput;
    }

    public static int readInt() {
        String stringInput = scanner.nextLine();
        validateNullAndEmpty(isNullOrEmpty(stringInput));
        return convertStringToInteger(stringInput);
    }

    private static boolean isNullOrEmpty(String input) {
        return (input.isEmpty() || input == null);
    }

    private static void validateNullAndEmpty(boolean isNullOrEmpty) {
        if (isNullOrEmpty) {
            throw new IllegalArgumentException(WARNING_NULL_AND_EMPTY);
        }
    }

    private static void validateIntegerType(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WARNING_INTEGER_FORMAT);
        }
    }

    public static int convertStringToInteger(String input) {
        validateIntegerType(input);
        return Integer.parseInt(input);
    }
}