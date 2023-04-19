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
}
