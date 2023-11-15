package calculator.model;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private static final String ERR_INVALID_OPERATOR = "Invalid operator: ";

    public static int calculateOnce(int left, int right, Operator operator) {
        if (operator == Operator.ADD) {
            return add(left, right);
        }
        if (operator == Operator.SUB) {
            return sub(left, right);
        }
        if (operator == Operator.MUL) {
            return multiple(left, right);
        }
        if (operator == Operator.DIV) {
            return divide(left, right);
        }
        throw new IllegalArgumentException(ERR_INVALID_OPERATOR + operator.toString());
    }

    private static int add(int left, int right) {
        return left + right;
    }

    private static int sub(int left, int right) {
        return left - right;
    }

    private static int multiple(int left, int right) {
        return left * right;
    }

    private static int divide(int left, int right) {
        return left / right;
    }
}
