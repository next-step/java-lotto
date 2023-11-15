package step1;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+") {
        @Override
        public int apply(Integer leftNumber, Integer rightNumber) {
            return leftNumber + rightNumber;
        }
    },
    MINUS("-") {
        @Override
        public int apply(Integer leftNumber, Integer rightNumber) {
            return leftNumber - rightNumber;
        }
    },
    MULTIPLICATION("*") {
        @Override
        public int apply(Integer leftNumber, Integer rightNumber) {
            return leftNumber * rightNumber;
        }
    },
    DIVISION("/") {
        @Override
        public int apply(Integer leftNumber, Integer rightNumber) {
            return leftNumber / rightNumber;
        }
    };

    private static final Map<String, Operator> operators =
            Stream.of(values()).collect(Collectors.toMap(op -> op.symbol, op -> op));
    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator findOperatorByUserInput(String symbol) {
        if (operators.containsKey(symbol)) {
            return operators.get(symbol);
        }
        throw new IllegalArgumentException("사칙연산의 기호가 아닙니다");
    }

    public abstract int apply(Integer leftNumber, Integer rightNumber);
}