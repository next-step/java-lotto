package stringpluscalculator.domain;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private InputStrategy inputStrategy;

    private Calculator(final InputStrategy inputStrategy) {
        this.inputStrategy = inputStrategy;
    }

    public static Calculator of(final String input) {
        if (input == null || input.trim().isEmpty()) {
            return new Calculator(new NullInputStrategy(input));
        }

        final Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            return new Calculator(new CustomInputStrategy(matcher.group(1), matcher.group(2)));
        }

        return new Calculator(new SimpleInputStrategy(input));
    }

    public int sum() {
        List<Integer> operands = inputStrategy.parse();
        int result = 0;

        for (Integer operand : operands) {
            result += operand;
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return Objects.equals(inputStrategy, that.inputStrategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputStrategy);
    }
}
