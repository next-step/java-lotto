package stringCalculator;

import static stringCalculator.Operator.findMark;

public class StringCalculator {
    private InputValidator validator;

    public StringCalculator() {
        validator = new InputValidator();
    }

    public long calculate(String input) {
        validator.validate(input);

        String[] values = input.split(" ");
        return performOperator(values);
    }

    private long performOperator(String[] values) {
        long sum = toLong(values[0]);

        for (int i = 1; i < values.length - 1; i += 2) {
            // String operator = values[i];
            Operator operator = findMark(values[i]);
            long currentNumber = toLong(values[i + 1]);

            sum = operator.process(sum, currentNumber);
        }

        return sum;
    }

    private long toLong(String string) {
        return Long.parseLong(string);
    }
}
