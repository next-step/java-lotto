package stringcalculator;

import java.util.List;

public class StringCalculator {
    public static final String NEGATIVE_NUMBER_CAN_NOT_BE_INCLUDED_ERR_MSG = "음수는 포함될 수 없습니다.";

    public int sum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        StringParser stringParser = new StringParser();
        List<Integer> numbers = stringParser.getNumbersFrom(input);

        int result = 0;
        for (Integer number : numbers) {
            validateNumber(number);
            result += number;
        }

        return result;
    }

    private void validateNumber(Integer number) {
        if (number < 0) {
            throw new RuntimeException(NEGATIVE_NUMBER_CAN_NOT_BE_INCLUDED_ERR_MSG);
        }
    }
}
