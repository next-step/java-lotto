package calculator.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+", Double::sum),
    MINUS("-", (number1, number2) -> number1 - number2),
    MULTIPLY("*", (number1, number2) -> number1 * number2),
    DIVIDE("/", (number1, number2) -> (double) (number1.intValue() / number2.intValue()));

    private static final String WRONG_OPERATOR_MESSAGE = "잘못된 연산자입니다.";

    private final String operator;
    private final BinaryOperator<Double> formula;

    Operator(String operator, BinaryOperator<Double> formula) {
        this.operator = operator;
        this.formula = formula;
    }

    private static final Map<String, Operator> operatorMap = Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(operator -> operator.operator, Function.identity())));

    public static Operator findOperator(String operator) {
        return Optional.ofNullable(operatorMap.get(operator))
                .orElseThrow(() -> new IllegalArgumentException(WRONG_OPERATOR_MESSAGE));
    }

    public double calculate(double number1, double number2) {
        return formula.apply(number1, number2);
    }
}
