package domain;

import java.util.Map;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum BasicOperator {
    ADD("+", (a, b) -> a + b),
    SUBSTRACTION("-", (a, b) -> a - b),
    MULTIPLICATION("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);
    private final String operator;
    private final IntBinaryOperator intBinaryOperator;

    BasicOperator(String operator, IntBinaryOperator intBinaryOperator) {
        this.operator = operator;
        this.intBinaryOperator = intBinaryOperator;
    }

    public int apply(int a, int b) {
        return intBinaryOperator.applyAsInt(a, b);
    }

    public static BasicOperator mapping(String operator) {
        Map<String, BasicOperator> mappingData = Stream.of(BasicOperator.values())
                .collect(toMap(BasicOperator::getOperator, Function.identity()));
        return mappingData.get(operator);
    }

    public String getOperator() {
        return operator;
    }
}
