package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (number1, number2) -> number1 + number2),
    MINUS("-", (number1, number2) -> number1 - number2),
    MULTIPLY("*", (number1, number2) -> number1 * number2),
    DIVIDE("/", (number1, number2) -> number1 / number2);

    private static final String MESSAGE_WRONG_OPERATOR = "잘못된 연산자입니다. 명시된 연산자를 사용하세요.[" + Arrays.toString(Operator.values()) + "]";

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> calculator;

    Operator(String operator, BiFunction<Integer, Integer, Integer> calculator) {
        this.operator = operator;
        this.calculator = calculator;
    }

    public static Integer calculate(List<Integer> operands, List<String> operators) {
        int sum = operands.get(0);
        for (int i = 0; i < operators.size(); i++) {
            sum = Operator.calculateSingle(operators.get(i), sum, operands.get(i + 1));
        }

        return sum;
    }

    public static Integer calculateSingle(String operator, Integer number1, Integer number2) {
        return getOperator(operator).calculator.apply(number1, number2);
    }

    private static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(operator+ "는 " + MESSAGE_WRONG_OPERATOR));
    }

    public String getOperator() {
        return operator;
    }
}
