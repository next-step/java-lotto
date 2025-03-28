package stringcalculator;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Operator {

    ADD("+") {
        @Override
        public int operate(int a, int b) {
            return a+b;
        }
    },
    SUBTRACT("-") {
        @Override
        public int operate(int a, int b) {
            return a-b;
        }
    },
    MULTIPLY("*") {
        @Override
        public int operate(int a, int b) {
            return a*b;
        }
    },
    DIVIDE("/") {
        @Override
        public int operate(int a, int b) {
            if (b == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return a/b;
        }
    };

    private final String symbol;

    Operator(String symbol) {

        this.symbol = symbol;
    }

    private static final Map<String, Operator> SYMBOL_MAP =
            Arrays.stream(values())
                    .collect(Collectors.toMap(op -> op.symbol, op -> op));

    public static Operator getBySymbol(String symbol) {
        Operator operator = SYMBOL_MAP.get(symbol);
        if (operator == null) {
            throw new IllegalArgumentException("사칙연산을 수행할 수 없는 문자열을 포함합니다");
        }
        return operator;
    }

    public abstract int operate(int a, int b);


}
