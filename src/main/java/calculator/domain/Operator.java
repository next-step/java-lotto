package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", (a, b) -> a + b),
    SUBTRACTION("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);

    private static final String INVALID_OPERATOR_MESSAGE = "올바른 연산자가 아닙니다.";
    private static final String INPUT_DIVIDE_EXCEPTION_MESSAGE = "나눗셈 연산은 정수로 떨어지는 경우만 가능 합니다.";

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static int execute(String operator, int a, int b) {
        Operator or = getOperator(operator);

        if(isDivisionOperator(or)) {
            validDivisionOperator(a, b);
        }

        return or.expression.apply(a, b);
    }

    private static boolean isDivisionOperator(Operator operator) {
        return operator.equals(DIVISION);
    }

    private static void validDivisionOperator(int a , int b) {
        if(a % b != 0) {
            throw new IllegalArgumentException(INPUT_DIVIDE_EXCEPTION_MESSAGE);
        }
    }

    private static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(INVALID_OPERATOR_MESSAGE));
    }
}
