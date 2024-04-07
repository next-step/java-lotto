package stringcalculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

public enum Operation {
    PLUS("+", ((num1, num2) -> num1 + num2)),
    MINUS("-", ((num1, num2) -> num1 - num2)),
    MULTIPLY("*", ((num1, num2) -> num1 * num2)),
    DIVIDE("/", ((num1, num2) -> num1 / num2));

    private String operation;
    private BiFunction<Integer, Integer, Integer> formula;

    Operation(String operation, BiFunction<Integer, Integer, Integer> formula) {
        this.operation = operation;
        this.formula = formula;
    }

    public static Operation checkOperation(String operation) {
        return Arrays.stream(values()).filter(operationEnum -> Objects.equals(operation, operationEnum.operation)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public Integer calculate(Integer num1, Integer num2) {
        return formula.apply(num1, num2);
    }

}
