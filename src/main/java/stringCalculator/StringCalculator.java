package stringCalculator;

import static stringCalculator.Operator.processWithValidation;

public class StringCalculator {
    private Validator validator;

    public StringCalculator() {
        validator = new Validator();
    }

    public long calculate(String input) {
        validator.validate(input);

        String[] values = input.split(" ");
        return performOperator(values);
    }

    private long performOperator(String[] values) {
        long sum = toLong(values[0]);

        for (int i = 1; i < values.length - 1; i += 2) {
            String operator = values[i];
            long currentNumber = toLong(values[i + 1]);

            sum = processWithValidation(sum, operator, currentNumber);
        }

        return sum;
    }

    private long toLong(String string) {
        return Long.parseLong(string);
    }
}
