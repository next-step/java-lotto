package domain;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS('+', ((num1, num22) -> new Number(num1.value() + num22.value()))),
    MINUS('-', (num1, num2) -> new Number(num1.value() - num2.value())),
    MULTIPLY('*', (num1, num2) -> new Number(num1.value() * num2.value())),
    DIVIDE('/', (num1, num2) -> {
        checkDivideZero(num2.value());
        return new Number(num1.value() / num2.value());
    })
    ;

    private static final String ERROR_CANNOT_DIVINE_BY_ZERO = "0으로 나눌 수는 없습니다.";
    private static final String ERROR_CANNOT_FIND_ARITHMETICOPERATOR = "해당 사칙연산과 일치하는 연산자를 찾을 수 없습니다.";
    private final Character arithmeticOperator;
    private final BinaryOperator<Number> expression;

    Operator(Character arithmeticOperator, BinaryOperator<Number> expression) {
        this.arithmeticOperator = arithmeticOperator;
        this.expression = expression;
    }

    public Number calculate(double num1, double num2) {
        return expression.apply(new Number(num1), new Number(num2));
    }

    public static Operator find(Character arithmeticOperator) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.arithmeticOperator.equals(arithmeticOperator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_CANNOT_FIND_ARITHMETICOPERATOR));
    }

    private static void checkDivideZero(double number) {
        if (number == 0) {
            throw new ArithmeticException(ERROR_CANNOT_DIVINE_BY_ZERO);
        }
    }
}
