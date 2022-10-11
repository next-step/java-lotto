package calculator.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    ADD("+", (num1, num2) -> num1 + num2),
    SUB("-", (num1, num2) -> num1 - num2),
    MUL("*", (num1, num2) -> num1 * num2),
    DIV("/", (num1, num2) -> num1 / num2);

    Operator(String opCode, BiFunction<Double, Double, Double> operator) {
        this.opCode = opCode;
        this.operator = operator;
    }

    private final String opCode;
    private final BiFunction<Double, Double, Double> operator;

    public String getOpCode() {
        return opCode;
    }

    public static Double execute(String opCode, double num1, double num2) {
        return getOperator(opCode).operator.apply(num1, num2);
    }

    private static final Map<String, Operator> map = Collections.unmodifiableMap(
        Stream.of(values())
            .collect(Collectors.toMap(Operator::getOpCode, Function.identity())));

    private static Operator getOperator(String opCode) {
        return Optional.ofNullable(map.get(opCode)).orElseThrow(IllegalArgumentException::new);
    }
}
