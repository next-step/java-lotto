package calculator;

import static calculator.Operations.*;

public class Calculator {
    private final Expression expression;
    private Result result;

    public Calculator(String expression) {
        this.expression = new Expression(expression);
    }

    public int calculate() {
        initializeResult();

        for (int index = 1; index < expression.size(); index += 2) {
            checkOperation(PLUS, index);
            checkOperation(MINUS, index);
            checkOperation(MULTIPLY, index);
            checkOperation(DIVIDE, index);
        }
        return result.get();
    }

    private void initializeResult() {
        result = new Result(Integer.parseInt(expression.firstValue()));
    }

    private void checkOperation(Operations operation, int index) {
        if (operation.equals(expression.get(index))) {
            result.apply(operation, numOfNextIndex(index));
        }
    }

    private int numOfNextIndex(int index) {
        return Integer.parseInt(expression.get(index + 1));
    }
}
