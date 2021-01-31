package stringcalculator;

public class StringCalculator {
    private final static String USE_NEGATIVE_NUMBER_ERROR_MESSAGE = "음수는 사용할 수 없습니다.";

    public int calculate(final String inputText) {
        if (nullOrEmpty(inputText)) {
            return 0;
        }
        String[] numberStrings = StringSplitter.split(inputText);
        if (numberStrings.length > 0) {
            return sum(numberStrings);
        }
        return Integer.parseInt(inputText);
    }

    private boolean nullOrEmpty(final String inputText) {
        return inputText == null || "".equals(inputText);
    }

    private int sum(final String[] numberStrings) {
        int sum = 0;
        for (final String token : numberStrings) {
            int number = Integer.parseInt(token);
            minusNumberThrowsException(number);
            sum += number;
        }
        return sum;
    }

    private void minusNumberThrowsException(final int number) {
        if (number < 0) {
            throw new RuntimeException(USE_NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }
}
