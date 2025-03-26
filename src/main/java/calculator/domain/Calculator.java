package calculator.domain;

import calculator.domain.exception.UnexpectedOperatorException;

public class Calculator {

    public Number calculate(String input) {
        String[] tokens = input.split(" ");
        Number result = new Number(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            Number right = new Number(tokens[i + 1]);
            result = operate(operator, result, right);
        }
        return result;
    }

    private Number operate(String operator, Number left, Number right) {
        if (operator.equals("+")) {
            return left.add(right);
        }
        if (operator.equals("-")) {
            return left.subtract(right);
        }
        if (operator.equals("*")) {
            return left.multiplyBy(right);
        }
        if (operator.equals("/")) {
            return left.divideBy(right);
        }
        throw new UnexpectedOperatorException();
    }
}
