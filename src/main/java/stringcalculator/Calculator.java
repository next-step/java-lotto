package stringcalculator;

public class Calculator {
    public static int calculate(String input) {
        validate(input);

        String[] tokens = input.split(" ");

        int result = Integer.parseInt(tokens[0]);

        for (int i = 1; i < tokens.length - 1; i += 2) {
            String symbol = tokens[i];
            int number = Integer.parseInt(tokens[i + 1]);
            result = Operator.of(symbol).operate(result, number);
        }
        return result;
    }

    private static void validate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("문자열을 입력해주세요.");
        }
    }
}
