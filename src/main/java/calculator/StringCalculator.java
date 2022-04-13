package calculator;

import calculator.operation.*;

public class StringCalculator {

    public int splitAndCalculate(String source) {
        checkSourceValidation(source);
        String[] splits = source.split(" ");
        int leftPort = PositiveInteger.toPositiveInteger(splits[0]);

        for (int i = 1; i < splits.length; i += 2) {
            validateArithmeticOperation(splits[i]);
            int rightPort = PositiveInteger.toPositiveInteger(splits[i + 1]);
            leftPort = calculateByOperation(splits[i], leftPort, rightPort);
        }

        return leftPort;
    }

    private void checkSourceValidation(String source) {
        if (source == null || source.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private int calculateByOperation(String operation, int leftPort, int rightPort) {
        CustomOperation dynamicOperation = findOperation(operation);
        return dynamicOperation.calculate(leftPort, rightPort);
    }

    private CustomOperation findOperation(String operation) {
        if (operation.equals("+")) {
            return new Addition();
        }
        if (operation.equals("-")) {
            return new Subtraction();
        }
        if (operation.equals("*")) {
            return new Multiplication();
        }
        return new Division();
    }

    private void validateArithmeticOperation(String operation) {
        if (!(operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/"))) {
            throw new IllegalArgumentException();
        }
    }
}
