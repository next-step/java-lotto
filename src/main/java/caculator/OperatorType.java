package caculator;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.BiFunction;

public enum OperatorType {
    PLUS("+", Number::plus),
    MINUS("-", Number::minus),
    DIVIDE("/", Number::divide),
    MULTIPLE("*", Number::multiple);

    private final String value;
    private final BiFunction<Number, Number, Number> operateFunc;


    OperatorType(String value, BiFunction<Number, Number, Number> operateFunc) {
        this.value = value;
        this.operateFunc = operateFunc;
    }

    Number apply(Number number, Number other) {
        return operateFunc.apply(number, other);
    }

    public static OperatorType findByValue(String value) {
        return Arrays.stream(OperatorType.values())
                .filter(it -> Objects.equals(it.value, value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
