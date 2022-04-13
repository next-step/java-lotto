package calculator;

import calculator.operation.*;

public class StringCalculator {

    public int splitAndCalculate(String source) {
        String[] splits = source.split(" ");
        int result = new PositiveInteger(splits[0]).getPositiveNumber();

        for (int i = 1; i < splits.length; i += 2) {
            validateArithmeticOperation(splits[i]);
            int rightPort = new PositiveInteger(splits[i + 1]).getPositiveNumber();
            result = calculateByOperation(splits[i], result, rightPort);
        }

        return result;
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
