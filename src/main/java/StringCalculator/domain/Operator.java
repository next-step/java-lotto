package StringCalculator.domain;

import java.util.Objects;

public class Operator {
    private final String symbol;

    public Operator(String symbol) {
        if (!isValidOperator(symbol)) {
            throw new IllegalArgumentException("유효하지 않은 연산자입니다: " + symbol);
        }
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isDivision() {
        return "/".equals(symbol);
    }

    private boolean isValidOperator(String symbol) {
        return symbol.matches("[\\+\\-\\*/]");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator = (Operator) o;
        return Objects.equals(symbol, operator.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    @Override
    public String toString() {
        return symbol;
    }
}
