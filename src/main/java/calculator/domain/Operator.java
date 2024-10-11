package calculator.domain;

import java.util.List;

public enum Operator {
    PLUS("+") {
        @Override
        public int calculate(Operand operand1, Operand operand2) {
            return operand1.value() + operand2.value();
        }
    },
    MINUS("-") {
        @Override
        public int calculate(Operand operand1, Operand operand2) {
            return operand1.value() - operand2.value();
        }
    },
    MULTIPLY("*") {
        @Override
        public int calculate(Operand operand1, Operand operand2) {
            return operand1.value() * operand2.value();
        }
    },
    DIVIDE("/") {
        @Override
        public int calculate(Operand operand1, Operand operand2) {
            if (operand2.value() == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            return operand1.value() / operand2.value();
        }
    },
    ;

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator getInstance(String symbol) {
        List<Operator> operators = List.of(Operator.values());
        for (Operator operator : operators) {
            if (operator.symbol.equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("symbol에 해당하는 연산자가 없습니다.");
    }

    public String getSymbol() {
        return this.symbol;
    }

    public abstract int calculate(Operand operand1, Operand operand2);
}
