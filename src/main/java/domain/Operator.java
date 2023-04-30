package domain;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (left, right) -> left + right),
    SUBTRACT("-", (left, right) -> left - right),
    MULTIPLY("*", (left, right) -> left * right),
    DIVIDE("/", (left, right) -> left / right);

    private String operation;
    private BiFunction<Integer, Integer, Integer> biFunction;

    Operator(String operation, BiFunction<Integer, Integer, Integer> biFunction) {
        this.operation = operation;
        this.biFunction = biFunction;
    }

    public Integer calculate(List<Integer> numbers) {
        if (this.operation.equals("/") && numbers.get(1) == 0) {
            throw new InvalidParameterException("0으로 나눌 수 없습니다.");
        }
        return biFunction.apply(numbers.get(0), numbers.get(1));
    }

    public static Operator toOperation(String operation) {
        for (Operator value : values()) {
            if (value.operation.equals(operation)) {
                return value;
            }
        }
        throw new InvalidParameterException("유효한 연산자가 아닙니다.");
    }
}
