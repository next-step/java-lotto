package stringcalulator.model;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static stringcalulator.model.Constant.Exception.*;

public enum Operator {
    PLUS("+") {
        public double operate(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double operate(double x, double y) {
            return x - y;
        }
    },
    MULTI("*") {
        public double operate(double x, double y) {
            return x * y;
        }
    },
    DIV("/") {
        public double operate(double x, double y) {
            if (y == 0) {
                throw new IllegalArgumentException(DOES_NOT_DIVIDE_ZERO);
            }
            return x / y;
        }
    };

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator findOperator(String operator) {
        return Arrays.stream(Operator.values())
                .filter(x -> x.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(NOT_EXIST_OPERATOR));
    }

    public abstract double operate(double x, double y);
}
