package calculation;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Calculation {
    PLUS("+", (a, b) -> a + b);

    private static final String OPERATOR_ERROR_MESSAGE = "error : 올바른 연산자가 아닙니다.";
    private String operator;
    private BiFunction<Integer, Integer, Integer> calculateValue;

    Calculation(String operator, BiFunction<Integer, Integer, Integer> calculateValue) {
        this.operator = operator;
        this.calculateValue = calculateValue;
    }

    public static int calculate(String operator, int firstNumber, int secondNumber){
        return findValidOperator(operator).calculateValue.apply(firstNumber, secondNumber);
    }

    private static Calculation findValidOperator(String operator){
        return Arrays.stream(values())
                .filter(formula -> formula.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(OPERATOR_ERROR_MESSAGE));
    }

}
