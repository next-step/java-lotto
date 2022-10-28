package lotto.util;

import lotto.exception.InvalidInputException;

public class NumberUtil {
    private static final String VALIDATE_NULL_OR_EMPTY_MESSAGE = "빈 값은 입력할 수 없습니다.";
    private static final String VALIDATE_INTEGER = "양수만 입력할 수 있습니다.";
    private static final String VALIDATE_AMOUNT = "음수는 입력할 수 없습니다.";

    private NumberUtil() {
        throw new AssertionError();
    }

    public static Integer convertAmountStringToInt(String input) {
        String validateInput = validateInput(input);
        Integer number = convertStringToInt(validateInput);
        if (number < 0) {
            throw new InvalidInputException(VALIDATE_AMOUNT);
        }
        return number;
    }

    public static Integer convertNumberStringToInt(String input) {
        String validateInput = validateInput(input);
        Integer number = convertStringToInt(validateInput);
        return validatePositive(number);
    }


    private static Integer convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(VALIDATE_INTEGER);
        }
    }

    private static Integer validatePositive(Integer parseInt) {
        if (parseInt <= 0) {
            throw new InvalidInputException(VALIDATE_INTEGER);
        }
        return parseInt;
    }

    private static String validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException(VALIDATE_NULL_OR_EMPTY_MESSAGE);
        }
        return input;
    }

}
