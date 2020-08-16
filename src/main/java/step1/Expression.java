package step1;

import java.util.Arrays;
import java.util.List;
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

    public Stream<Integer> stream() {
        return targetNumbers.stream();
    }

    private static int throwIfNumberIsNegative(int target) {
        if (target < 0) {
            throw new RuntimeException("The given number is negative!");
        }
        return target;
    }
}
