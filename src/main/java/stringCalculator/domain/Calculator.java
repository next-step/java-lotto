package stringCalculator.domain;

import stringCalculator.utils.Message;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    enum Operator {
        PLUS("+"){
            @Override
            public int operate(int x, int y) {
                return x + y;
            }
        },
        MINUS("-"){
            @Override
            public int operate(int x, int y) {
                return x - y;
            }
        },
        MULTIPLY("*"){
            @Override
            public int operate(int x, int y) {
                return x * y;
            }
        },
        DIVIDE("/"){
            @Override
            public int operate(int x, int y) {
                return x / y;
            }
        };

        private final String operator;

        Operator(String operator) {
            this.operator = operator;
        }

        public abstract int operate(int x, int y);
    }

    private static final Map<String, Operator> operators = new HashMap<>();

    public Calculator() {
        for (Operator value : Operator.values()) {
            operators.put(value.operator, value);
        }
    }

    public int calculate(String operator, int x, int y) {
        if (operators.get(operator) == null) {
            throw new IllegalArgumentException(Message.CALCULATOR_OPERATOR_EXCEPTION.getMessage());
        }
        return operators.get(operator).operate(x, y);
    }
}
