public class StringAddCalculator {

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        if (input.length() == 1) {
            return new PositiveNumber(input).getPositiveNumber();
        }

        return result(input);
    }

    private static int result(String input) {
        if (CustomDelimiter.find(input)) {
            return CustomDelimiter.sum();
        }

        return DefaultDelimiter.sum(input);
    }
}
