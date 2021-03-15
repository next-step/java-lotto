package stringcalculator;

public class StringAddCalculator {

    private static final int NULL_OR_ZER0 = 0;

    public int splitAndSum(String input) {
        if (isInValidation(input)) {
            return NULL_OR_ZER0;
        }

        String[] tokens = StringTokenizer.splitString(input);

        int result = 0;
        for (String token : tokens) {
            result = sum(result, new Number(Integer.parseInt(token)).getNumber());
        }

        return result;
    }

    public boolean isInValidation(String input) {
        return input == null || input.isEmpty();
    }

    public int sum(int left, int right) {
        return left + right;
    }
}
