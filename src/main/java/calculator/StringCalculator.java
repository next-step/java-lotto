package calculator;

import calculator.operation.*;

import static calculator.operation.ArithmeticOperation.*;

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
            throw new IllegalArgumentException("입력 값이 null 혹은 공백일 수는 없습니다!");
        }
    }

    private void validateArithmeticOperation(String operation) {
        if (!(isAddition(operation) || isSubtraction(operation) || isMultiplication(operation) || isDivision(operation))) {
            throw new IllegalArgumentException("적절한 사칙연산이 들어오지 않았습니다!");
        }
    }

    private int calculateByOperation(String operation, int leftPort, int rightPort) {
        CustomOperation dynamicOperation = findOperation(operation);
        return dynamicOperation.calculate(leftPort, rightPort);
    }

    private CustomOperation findOperation(String operation) {
        if (isAddition(operation)) {
            return new Addition();
        }
        if (isSubtraction(operation)) {
            return new Subtraction();
        }
        if (isMultiplication(operation)) {
            return new Multiplication();
        }
        if (isDivision(operation)) {
            return new Division();
        }
        throw new IllegalArgumentException("적절한 사칙연산이 들어오지 않았습니다!");
    }

    private boolean isAddition(String operation) {
        return operation.equals(ADDITION.getOperation());
    }

    private boolean isSubtraction(String operation) {
        return operation.equals(SUBTRACTION.getOperation());
    }

    private boolean isMultiplication(String operation) {
        return operation.equals(MULTIPLICATION.getOperation());
    }

    private boolean isDivision(String operation) {
        return operation.equals(DIVISION.getOperation());
    }
}
