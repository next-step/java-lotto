package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

public enum Operation {

    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> {
        if (y == 0) throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        return x / y;
    });

    private static final String OPERATOR = "[+\\-*/]";
    private static final Pattern REGULAR_OPERATOR = Pattern.compile(OPERATOR);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operation(final String operator, final BiFunction<Integer, Integer, Integer> expression) {

        this.operator = operator;
        this.expression = expression;
    }

    public int calculate(final int number1, final int number2) {

        return expression.apply(number1, number2);
    }

    public static Operation from(final String operator) {

        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getOperator().equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("+, -, * / 이외 다른 연산자는 불가능합니다."));
    }

    public static boolean match(final String operator) {

        return REGULAR_OPERATOR.matcher(operator).find();
    }

    public String getOperator() {

        return operator;
    }
}