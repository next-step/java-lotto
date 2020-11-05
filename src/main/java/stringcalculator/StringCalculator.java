package stringcalculator;

import stringcalculator.exception.NegativeNumberIncludedException;

import java.util.List;

public class StringCalculator {
    public static final String NEGATIVE_NUMBER_CAN_NOT_BE_INCLUDED_ERR_MSG = "음수는 포함될 수 없습니다.";
    private final StringParser stringParser;

    public StringCalculator() {
        this.stringParser = new StringParser();
    }

    public int sum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        List<Integer> numbers = stringParser.getNumbersFrom(input);

        return sumNumbers(numbers);
    }

    private int sumNumbers(List<Integer> numbers) {
        int result = 0;
        for (Integer number : numbers) {
            validateNumber(number);
            result += number;
        }
        return result;
    }

    private void validateNumber(Integer number) {
        if (number < 0) {
            throw new NegativeNumberIncludedException(NEGATIVE_NUMBER_CAN_NOT_BE_INCLUDED_ERR_MSG);
        }
    }
}
