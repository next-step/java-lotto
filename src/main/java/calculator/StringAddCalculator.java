package calculator;

public class StringAddCalculator {

    public StringAddCalculator() {
    }

    public int splitAndSum(String input) {
        if (isNullOrBlank(input)) {
            return 0;
        }
        return Integer.parseInt(input);
    }

    private boolean isNullOrBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

}
