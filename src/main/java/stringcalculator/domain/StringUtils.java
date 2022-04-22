package stringcalculator.domain;

import stringcalculator.exception.BlankInputException;
import stringcalculator.exception.InvalidNumberException;

public class StringUtils {

    private StringUtils() {
    }

    static int toInt(String[] split, int index) {
        try {
            return Integer.parseInt(split[index]);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
    }

    static String[] getStringArray(String input) {
        validateInput(input);
        String[] stringArray = input.split(" ");
        validateArray(stringArray);
        return stringArray;
    }

    private static void validateArray(String[] stringArray) {
        if (isLessThanThreeValues(stringArray)) {
            throw new IllegalArgumentException("입력값은 3개 이상이어야 합니다.");
        }
        if (stringArray.length % 2 == 0) {
            throw new IllegalArgumentException("입력값은 홀수개이어야 합니다.");
        }
    }

    private static boolean isLessThanThreeValues(String[] stringArray) {
        return stringArray.length < 3;
    }

    private static void validateInput(String input) {
        if (isBlank(input)) {
            throw new BlankInputException();
        }
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }


}