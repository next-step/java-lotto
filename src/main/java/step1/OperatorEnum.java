package step1;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum OperatorEnum {

    ADD("+", (num1, num2) -> num1 + num2),
    SUB("-", (num1, num2) -> num1 - num2),
    MUL("*", (num1, num2) -> num1 * num2),
    DIV("/", (num1, num2) -> num1 / num2);

    private String symbol;
    private BiFunction<Integer, Integer, Integer> operator;

    private static final Map<String, BiFunction> OPERATOR_MAP = Collections.unmodifiableMap(
        Stream.of(values()).collect(Collectors.toMap(OperatorEnum::getSymbol, OperatorEnum::getOperator)));

    public static BiFunction getOperator(String symbol) {
        Optional<BiFunction> op = Optional.ofNullable(OPERATOR_MAP.get(symbol));
        return op.orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다"));
    }
}
