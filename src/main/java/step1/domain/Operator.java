package step1.domain;

import java.util.function.BiFunction;

public enum Operator implements OperatorType {
    ADD("+", (number1, number2) -> number1 + number2),
    SUBTRACT("-",(number1, number2) -> number1 - number2),
    MULTIPLY("*",(number1, number2) -> number1 * number2),
    DIVIDE("/",(number1, number2) -> number1 / number2);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> expression;

    public static Operator fromString(String text) {
        for (Operator operation : Operator.values()) {
            if (isEqualsTo(text, operation)) {
                return operation;
            }
        }
        throw new IllegalStateException("'+,-,*,/'이외의 연산자는 사용할 수 없습니다.");
    }

    private static boolean isEqualsTo(String text, Operator operation) {
        return operation.symbol.equals(text);
    }

    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    @Override
    public int calculate(int number1, int number2) {
        return  expression.apply(number1, number2);
    }

}
