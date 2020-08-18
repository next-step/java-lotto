package step1;

import step1.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Expression {
    public static final String DEFAULT_DELIMITER = "[,:]";

    private final List<Integer> targetNumbers;

    public Expression(List<Integer> targetNumbers) {
        this(targetNumbers, Expression::throwIfNumberIsNegative);
    }

    public Expression(List<Integer> targetNumbers, Function<Integer, Integer> validator) {
        this.targetNumbers = targetNumbers.stream().map(validator).collect(Collectors.toList());
    }

    public static Expression of(String text) {
        return of(text, DEFAULT_DELIMITER);
    }

    public static Expression of(String customText, String delimiter) {
        String[] splitedStrings = customText.split(delimiter);
        List<Integer> numbers = Arrays.stream(splitedStrings)
                .map(StringUtils::parseInt)
                .collect(Collectors.toList());

        return new Expression(numbers);
    }

    public int calculate() {
        return targetNumbers.stream().reduce(0, (acc, cur) -> acc += cur);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return Objects.equals(targetNumbers, that.targetNumbers);
    }

    @Override
    public int hashCode() {
        return targetNumbers.hashCode();
    }

    private static int throwIfNumberIsNegative(int target) {
        if (target < 0) {
            throw new RuntimeException("The given number is negative!");
        }
        return target;
    }
}
