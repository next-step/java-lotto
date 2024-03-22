package Calculator;

public class Calculator {
    public static int calculate(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("input string must not null or empty");
        }
        return calculateArray(splitInput(input));
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private static String[] splitInput(String input) {
        return StringUtils.split(input, " ");
    }

    private static int calculateArray(String[] values) {
        int length = values.length;
        int result = toInt(values[0]);

        for (int i = 0; i < length - 2; i+=2) {
            String operation = values[i + 1];
            result = calculate(result, toInt(values[i + 2]), operation);
        }
        return result;
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }

    private static int calculate(int a, int b, String operation) {
        return Operation.getStrategy(operation).operate(a, b);
    }
}
