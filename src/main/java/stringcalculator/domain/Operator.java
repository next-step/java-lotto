package stringcalculator.domain;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static int operation(String symbol, int precedingOperand, int followingOperand) {
        if (symbol.equals(PLUS.symbol)) {
            precedingOperand += followingOperand;
        } else if (symbol.equals(MINUS.symbol)) {
            precedingOperand -= followingOperand;
        } else if (symbol.equals(MULTIPLY.symbol)) {
            precedingOperand *= followingOperand;
        } else if (symbol.equals(DIVIDE.symbol)) {
            if (followingOperand == 0) {
                throw new IllegalArgumentException("Cannot divide by zero");
            }
            precedingOperand /= followingOperand;
        } else {
            throw new IllegalArgumentException("Invalid operator");
        }
        return precedingOperand;
    }
}
