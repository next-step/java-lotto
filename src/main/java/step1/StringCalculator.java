package step1;

public class StringCalculator {

    public int splitAndSum(String input) {
        if (isNullOrBlank(input)) {
            return 0;
        }
        return 0;
    }

    private boolean isNullOrBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}
