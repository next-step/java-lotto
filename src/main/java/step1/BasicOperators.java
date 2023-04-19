package step1;

public enum BasicOperators {

    PLUS("+", (prevValue, presentValue) -> prevValue + presentValue),
    MINUS("-", (prevValue, presentValue) -> prevValue - presentValue),
    MULTIPLY("*", (prevValue, presentValue) -> prevValue * presentValue),
    DIVIDE("/", (prevValue, presentValue) -> prevValue / presentValue);

    private final String symbol;

    private final Operators operators;

    BasicOperators(String symbol, Operators operators) {
        this.symbol = symbol;
        this.operators = operators;
    }

    public static int operate(int prevNum, int nextNum, String operator) {
        if (operator.equals(PLUS.symbol)) {
            return PLUS.operators.operate(prevNum, nextNum);
        }
        if (operator.equals(MINUS.symbol)) {
            return MINUS.operators.operate(prevNum, nextNum);
        }
        if (operator.equals(MULTIPLY.symbol)) {
            return MULTIPLY.operators.operate(prevNum, nextNum);
        }
        if (operator.equals(DIVIDE.symbol)) {
            return DIVIDE.operators.operate(prevNum, nextNum);
        }
        throw new IllegalArgumentException("올바르지 않는 연산자가 포함되어 있습니다.");
    }
}
