package stringCalculator;

import static stringCalculator.Operator.*;

public class Calculator {
    private static final int INIT = 0;

    public int calculate(int a, int b, Values values) {
        int result = INIT;
        String operator = values.pollOperator();

        if (operator.equals(PLUS.getValue())) {
            result = a + b;
        }

        if (operator.equals(MINUS.getValue())) {
            result = a - b;
        }

        if (operator.equals(MULTIPLE.getValue())) {
            result = a * b;
        }

        if (operator.equals(DIVIDE.getValue())) {
            result = a / b;
        }

        if (!values.operators.isEmpty()) {
            return calculate(result, values.pollOperand(), values);
        }

        return result;
    }
}
