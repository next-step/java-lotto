package calculator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum Operation {
    ADD_OPERATOR("+"),
    SUBTRACT_OPERATOR("-"),
    MULTIPLY_OPERATOR("*"),
    DIVIDE_OPERATOR("/")
    ;

    private final static String ILLEGAL_OPERATOR_EXCEPTION = "잘못된 사칙연산 기호입니다.";

    private final String operator;

    Operation(String operator) {
        this.operator = operator;
    }

    private static void validateOperators(List<String> operators) throws IllegalArgumentException {
        if (operators.stream().anyMatch(operator -> !isValidArithmeticOperation(operator))) {
            throw new IllegalArgumentException(ILLEGAL_OPERATOR_EXCEPTION);
        };
    }

    public static List<String> getFrom(List<String> inputs) throws IllegalArgumentException {
        List<String> operators = inputs.stream()
                .filter(input -> !Digit.isDigit(input))
                .collect(Collectors.toList());

        validateOperators(operators);
        return operators;
    }

    private static boolean isValidArithmeticOperation(String operator) {
        return isAddOperator(operator)
                || isSubtractOperator(operator)
                || isMultiplyOperator(operator)
                || isDivideOperator(operator);
    }

    public static boolean isAddOperator(String operator) {
        return Objects.equals(operator, ADD_OPERATOR.operator);
    }

    public static boolean isSubtractOperator(String operator) {
        return Objects.equals(operator, SUBTRACT_OPERATOR.operator);
    }

    public static boolean isMultiplyOperator(String operator) {
        return Objects.equals(operator, MULTIPLY_OPERATOR.operator);
    }

    public static boolean isDivideOperator(String operator) {
        return Objects.equals(operator, DIVIDE_OPERATOR.operator);
    }
}
