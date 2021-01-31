package stringcalculator;

import java.util.Arrays;

public class StringCalculator {
    public int calculate(final String inputText) {
        if (nullOrEmpty(inputText)) {
            return 0;
        }
        String[] numberStrings = StringParser.split(inputText);
        if (numberExists(numberStrings)) {
            return sum(numberStrings);
        }
        return Integer.parseInt(inputText);
    }

    private boolean nullOrEmpty(final String inputText) {
        return inputText == null || "".equals(inputText);
    }

    private boolean numberExists(final String[] numbersString) {
        return numbersString.length > 0;
    }

    private int sum(final String[] numberStrings) {
        return Arrays.stream(numberStrings)
                .map(numberString -> {
                    int number = Integer.parseInt(numberString);
                    minusNumberThrowsException(number);
                    return number;
                })
                .reduce(0, Integer::sum);
    }

    private void minusNumberThrowsException(final int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 사용할 수 없습니다.");
        }
    }
}
