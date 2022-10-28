package lotto.util;

import lotto.exception.InvalidInputException;

public class NumberUtil {
    private static final String VALIDATE_NULL_OR_EMPTY_MESSAGE = "빈 값은 입력할 수 없습니다.";
    private static final String VALIDATE_INTEGER = "양수만 입력할 수 있습니다.";

    private NumberUtil() {
        throw new AssertionError();
    }

    public static Integer convertStringToInt(String input) {
        String validatedInput = validateInput(input);

        try {
            int parseInt = Integer.parseInt(validatedInput);
            if (parseInt <= 0) {
                throw new InvalidInputException(VALIDATE_INTEGER);
            }
            return parseInt;
        } catch (NumberFormatException e) {
            throw new InvalidInputException(VALIDATE_INTEGER);
        }
    }

    private static String validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException(VALIDATE_NULL_OR_EMPTY_MESSAGE);
        }
        return input;
    }

}
