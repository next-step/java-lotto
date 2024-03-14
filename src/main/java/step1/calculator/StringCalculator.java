package step1.calculator;

import step1.validator.OperationValidator;

public class StringCalculator {
    private final OperationValidator validator;

    public StringCalculator() {
        validator = new OperationValidator();
    }

    public int calculate(String input) {
        validator.assertOperation(input);

        String[] tokens = input.split(" ");
        int operand1 = toInt(tokens[0]);
        for (int i = 1; i <= tokens.length - 2; i += 2) {
            String operator = tokens[i];
            int operand2 = toInt(tokens[i + 1]);

            Operation operation = Operation.find(operator);
            operand1 = operation.apply(operand1, operand2);
        }

        return operand1;
    }

    private int toInt(String value) {
        return Integer.parseInt(value);
    }

}
