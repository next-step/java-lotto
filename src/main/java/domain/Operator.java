package domain;

import java.util.HashMap;
import java.util.Map;

public enum Operator {
    PLUS("+") {
        @Override
        public int calculate(int number1, int number2) {
            return number1 + number2;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int number1, int number2) {
            return number1 - number2;
        }
    },
    MULTIPLY("*") {
        @Override
        public int calculate(int number1, int number2) {
            return number1 * number2;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int number1, int number2) {
            if (number2 == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            return number1 / number2;
        }
    };

    private static final Map<String, Operator> operatorMap = new HashMap<>();

    static {
        for (Operator operator : Operator.values()) {
            operatorMap.put(operator.symbol, operator);
        }
    }

    public static Operator getInstance(String symbol) {
        Operator operator = operatorMap.get(symbol);
        if (operator == null) {
            throw new IllegalArgumentException("잘못된 사칙연산 기호입니다 : " + symbol);
        }
        ;

        return operator;
    }

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public abstract int calculate(int number1, int number2);
}
