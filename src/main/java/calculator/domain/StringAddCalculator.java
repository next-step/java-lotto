package calculator.domain;

import java.util.List;

public class StringAddCalculator {

    public int splitAndSum(final String input) {
        final List<Number> numbers = NumberGenerator.generate(input);
        return numbers.stream()
                .reduce(Number.ZERO, Number::add)
                .getNumber();
    }
}
