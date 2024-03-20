package step1_caculator.type;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public enum OperatorType {
    PLUS("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLE("*");

    private final String value;

    OperatorType(String value) {
        this.value = value;
    }

    public static boolean isOperator(String value){
        return Arrays.stream(OperatorType.values())
                .anyMatch(it -> Objects.equals(it.value, value));
    }

    public static OperatorType of(String value) {
        return Arrays.stream(OperatorType.values())
                .filter(it -> Objects.equals(it.value, value))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
}
