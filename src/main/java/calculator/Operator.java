package calculator;

import javax.swing.text.html.Option;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+"){ int calculate(int num1, int num2) { return num1 + num2; }},
    MINUS("-") { int calculate(int num1, int num2) { return num1 - num2; }},
    MULTIPLY("*") { int calculate(int num1, int num2) { return num1 * num2; }},
    DIVIDE("/") { int calculate(int num1, int num2) { return num1 / num2; }};

    private String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    abstract int calculate(int num1, int num2);

    @Override
    public String toString() {
        return symbol;
    }

    private static final Map<String, Operator> stringToEnum = Stream.of(values()).collect(Collectors.toMap(Objects::toString, e -> e));

    public static Operator fromString(String symbol) {
        return stringToEnum.get(symbol);
    }
}
