package step1.domain;

/**
 *
 */
public class Calculator {

    public Number calculate(Number left, Number right, String operator) {
        Operation operation = OperationFactory.getOperation(operator);
        return operation.operate(left, right);
    }

    public Number calculate(String[] tokens) {
        if (tokens.length < 3) {
            throw new IllegalArgumentException("연산이 불가능한 숫자입니다.");
        }
        // if (tokens[tokens.length-1].equals(""))
        Number left = Number.of(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            Operation operation = OperationFactory.getOperation(operator);
            Number right = Number.of(tokens[i + 1]);
            left = operation.operate(left, right);
        }
        return left;
    }
}
