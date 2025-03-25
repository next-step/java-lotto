package step1;

import java.util.List;

public class Operator {
    private final String symbol;
    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    public Operator(String symbol) {
        if (symbol == null || symbol.isEmpty()) {
            throw new IllegalArgumentException("연산자가 입력되지 않았습니다.");
        }
        if (!List.of(ADD, SUBTRACT, MULTIPLY, DIVIDE).contains(symbol)) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다. 값 : " + symbol);
        }
        this.symbol = symbol;
    }

    public int apply(int a, int b) {
        if (symbol.equals(ADD)) {
            return a + b;
        }
        if (symbol.equals(SUBTRACT)) {
            return a - b;
        }
        if (symbol.equals(MULTIPLY)) {
            return a * b;
        }
        if (symbol.equals(DIVIDE)) {
            if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
            if (a % b != 0) throw new ArithmeticException("나눗셈의 결과가 정수가 아닙니다.");
            return a / b;
        }
        throw new IllegalStateException("사칙연산 기호가 아닙니다. 값 : " + symbol);
    }
}
