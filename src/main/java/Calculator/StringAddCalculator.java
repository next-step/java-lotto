package Calculator;

public class StringAddCalculator {
    public static int splitAndSum(final String inputString) {
        return validateInputString(inputString) ? Integer.parseInt(inputString) : 0;
    }

    private static boolean validateInputString(final String inputString) {
        return inputString != null && !inputString.isEmpty();
    }
}
