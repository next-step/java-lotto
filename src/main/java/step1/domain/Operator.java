package step1.domain;

import step1.config.exception.DivideByZeroException;
import step1.config.message.ErrorMessage;

import java.util.function.BiFunction;

import static step1.config.message.ErrorMessage.DIVIDE_BY_ZERO_NOT_ALLOWED;


public enum Operator implements OperatorType {
    ADD("+", (number1, number2) -> number1 + number2),
    SUBTRACT("-", (number1, number2) -> number1 - number2),
    MULTIPLY("*", (number1, number2) -> number1 * number2),
    DIVIDE("/", (number1, number2) -> {
        if (number2 == 0) {
            throw new DivideByZeroException();
        }
        return number1 / number2;
    });

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public static Operator find(String text) {
        for (Operator operation : values()) {
            if (operation.matches(text)) {
                return operation;
            }
        }
        throw new IllegalStateException(ErrorMessage.OPERATOR_VALIDATION.message(text));
    }

    public boolean matches(String text) {
        return this.symbol.equals(text);
    }

    @Override
    public int calculate(int number1, int number2) {
        return expression.apply(number1, number2);
    }
}
