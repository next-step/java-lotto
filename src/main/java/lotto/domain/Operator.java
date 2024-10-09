package lotto.domain;

import java.util.List;

public enum Operator {
    PLUS("+") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },
    MINUS("-") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    },
    MULTIPLY("*") {
        @Override
        public int calculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(int operand1, int operand2) {
            if (operand2 == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            return operand1 / operand2;
        }
    },;

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator getInstance(String symbol) {
        List<Operator> operators = List.of(Operator.values());
        for(Operator operator: operators) {
            if(operator.symbol.equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("symbol에 해당하는 연산자가 없습니다.");
    }

    public String getSymbol() {
        return this.symbol;
    }

    public abstract int calculate(int operand1, int operand2);
}
