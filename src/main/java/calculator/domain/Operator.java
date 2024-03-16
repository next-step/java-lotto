package calculator.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+", Double::sum),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> (double) (num1.intValue() / num2.intValue()));

    private static final String WRONG_OPERATOR_MESSAGE = "잘못된 연산자입니다.";

    private final String operator;
    private final BiFunction<Double, Double, Double> formula;

    Operator(String operator, BiFunction<Double, Double, Double> formula) {
        this.operator = operator;
        this.formula = formula;
    }

    private static final Map<String, Operator> operatorMap = Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(operator -> operator.operator, Function.identity())));

    public static Operator findOperator(String operator) {
        return Optional.ofNullable(operatorMap.get(operator))
                .orElseThrow(() -> new IllegalArgumentException(WRONG_OPERATOR_MESSAGE));
    }

    public double calculate(double num1, double num2) {
        return formula.apply(num1, num2);
    }
}
