package stringcalculator;

public class StringCalculator {
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

    private int sumNumbers(final String[] tokens) {
        int sum = 0;
        for (final String token : tokens) {
            int number = Integer.parseInt(token);
            minusNumberThrowsException(number);
            sum += number;
        }
        return sum;
    }

    private void minusNumberThrowsException(final int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 사용할 수 없습니다.");
        }
    }
}
