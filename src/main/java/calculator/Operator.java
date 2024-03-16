package calculator;

import java.util.Collections;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.nonNull;

public enum Operator {
    PLUS("+", Double::sum),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> (double) (num1.intValue() / num2.intValue()));

    private final String operator;
    private final BiFunction<Double, Double, Double> formula;

    Operator(String operator, BiFunction<Double, Double, Double> formula) {
        this.operator = operator;
        this.formula = formula;
    }

    private static final Map<String, Operator> operatorMap = Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(operator -> operator.operator, Function.identity())));

    public static boolean isValidOperator(String operator) {
        return nonNull(operatorMap.get(operator));
    }

    public double calculate(double num1, double num2) {
        return formula.apply(num1, num2);
    }
}
