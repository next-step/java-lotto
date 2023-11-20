package camp.nextstep.edu.calculator;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private static final Map<String, Operator> symbolToOperator
        = Stream.of(values()).collect(Collectors.toMap(Operator::symbol, e -> e));

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    static Operator from(String symbol) {
        if (!symbolToOperator.containsKey(symbol)) {
            throw new IllegalArgumentException("지원하지 않는 잘못된 연산자입니다.");
        }
        return symbolToOperator.get(symbol);
    }

    int operate(int left, int right) {
        if ("+".equals(this.symbol)) {
            return left + right;
        }
        if ("-".equals(this.symbol)) {
            return left - right;
        }
        if ("*".equals(this.symbol)) {
            return left * right;
        }
        return left / right;
    }

    private String symbol() {
        return this.symbol;
    }
}
