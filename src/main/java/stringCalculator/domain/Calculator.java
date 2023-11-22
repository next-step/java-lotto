package stringCalculator.domain;

import stringCalculator.utils.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {
    enum Operator {
        PLUS("+", (x , y) -> x + y),
        MINUS("-", (x , y) -> x - y),
        MULTIPLY("*", (x, y) -> x * y),
        DIVIDE("/", (x, y) -> x / y);

        private final String symbol;
        private final BiFunction<Integer, Integer, Integer> operator;

        Operator(String symbol, BiFunction<Integer, Integer, Integer> operator) {
            this.symbol = symbol;
            this.operator = operator;
        }

        public int operate(int x, int y) {
            return operator.apply(x, y);
        }
    }

    private static final Map<String, Operator> operators = new HashMap<>();

    public Calculator() {
        for (Operator value : Operator.values()) {
            operators.put(value.symbol, value);
        }
    }

    public int calculate(String operator, int x, int y) {
        if (operators.get(operator) == null) {
            throw new IllegalArgumentException(Message.CALCULATOR_OPERATOR_EXCEPTION.getMessage());
        }
        return operators.get(operator).operate(x, y);
    }
}
