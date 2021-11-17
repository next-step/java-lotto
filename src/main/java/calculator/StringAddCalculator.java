package calculator;

public class StringAddCalculator {
    private static final int NUMBER_ZERO = 0;
    private static final String STRING_BLANK = "";

    public int splitAndSum(String inputValue) {
        if (isNullOrBlank(inputValue)) {
            return NUMBER_ZERO;
        }

        return NUMBER_ZERO;
    }

    private boolean isNullOrBlank(String inputValue) {
        return inputValue == null || inputValue == STRING_BLANK;
    }
}
