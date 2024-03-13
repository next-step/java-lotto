package step1;

import static step1.Operation.performOperation;

public class StringCalculator {
    private final Validator validator;

    public StringCalculator() {
        validator = new Validator();
    }

    public int calculate(String input) {
        validator.assertValidInput(input);

        String[] tokens = input.split(" ");
        int operand1 = toInt(tokens[0]);
        for (int i = 1; i <= tokens.length - 1; i += 2) {
            String symbol = tokens[i];
            int operand2 = toInt(tokens[i + 1]);

            operand1 = performOperation(operand1, symbol, operand2);
        }

        return operand1;
    }

    private int toInt(String value) {
        return Integer.parseInt(value);
    }

}
