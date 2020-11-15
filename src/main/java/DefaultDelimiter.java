public final class DefaultDelimiter {

    private static final String DEFAULT_DELIMITER = "[,:]";

    public static int sum(String input) {
        String[] numbers = input.split(DEFAULT_DELIMITER);
        return CalculatorUtils.sum(numbers);
    }
}
