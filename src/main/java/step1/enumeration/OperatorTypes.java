package step1.enumeration;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorTypes {

    PLUS("+", Integer::sum),
    TAKE_OUT("-", (firstNumber, secondNumber) -> firstNumber - secondNumber),
    MULTIPLY("*", (firstNumber, secondNumber) -> firstNumber * secondNumber),
    DIVISION("/", Math::floorDiv)
    ;

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> operation;

    OperatorTypes(String operator, BiFunction<Integer, Integer, Integer> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public String getOperator() {
        return this.operator;
    }

    public static int calculate(int result, int number, String operator) {
        return Arrays.stream(values())
                .filter(operatorType -> operatorType.getOperator().equals(operator))
                .findFirst()
                .map(operatorType -> operatorType.operation.apply(result, number))
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다."));
    }

}
