package calculator;

import calculator.operation.*;

import static calculator.operation.ArithmeticOperation.*;
import static java.util.Arrays.*;

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
        if (stream(values()).noneMatch(arithmeticOperation -> arithmeticOperation
                .getOperation()
                .equals(operation))) {
            throw new IllegalArgumentException("적절한 사칙연산이 들어오지 않았습니다!");
        }
    }

    private int calculateByOperation(String operation, int leftPort, int rightPort) {
        CustomOperation dynamicOperation = findOperation(operation);
        return dynamicOperation.calculate(leftPort, rightPort);
    }

    private CustomOperation findOperation(String operation) {
        for (ArithmeticOperation arithmeticOperation : values()) {
            if (arithmeticOperation.getOperation().equals(operation)) {
                return arithmeticOperation.getCustomOperation();
            }
        }
        throw new IllegalArgumentException("적절한 사칙연산이 들어오지 않았습니다!");
    }

}
