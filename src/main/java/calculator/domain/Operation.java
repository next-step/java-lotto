package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public enum Operation {

    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> {
        if (y == 0) throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        return x / y;
    });

    private static final int TWO_DIGIT_STRING = 2;
    private static final String OPERATION = "[+\\-*/]";
    private static final Pattern REGULAR_OPERATION = Pattern.compile(OPERATION);

    private final String operation;
    private final BiFunction<Long, Long, Long> expression;

    Operation(final String operation, final BiFunction<Long, Long, Long> expression) {

        this.operation = operation;
        this.expression = expression;
    }

    public static List<Operation> from(final List<String> expressions) {

        return expressions.stream()
                .filter(Operation::match)
                .map(Operation::from)
                .collect(Collectors.toList());
    }

    public long calculate(final long number1, final long number2) {

        return expression.apply(number1, number2);
    }

    public static Operation from(final String operation) {

        validateNullOrEmpty(operation);
        validateNoBlank(operation);

        return Arrays.stream(Operation.values())
                .filter(value -> value.getOperation().equals(operation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("+, -, * / 이외 다른 연산자는 불가능합니다."));
    }

    public static boolean match(final String operation) {

        return REGULAR_OPERATION.matcher(operation).find();
    }

    public String getOperation() {

        return operation;
    }

    private static void validateNullOrEmpty(final String operation) {

        if (operation == null || operation.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null 또는 빈 공백 입니다.");
        }
    }

    private static void validateNoBlank(final String operation) {

        if (operation.length() >= TWO_DIGIT_STRING && match(operation)) {
            throw new IllegalArgumentException("연산식의 숫자 또는 연산자 사이에 빈 공간이 없습니다.");
        }
    }
}