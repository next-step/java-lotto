package stringcalculator.domain;

import java.util.List;

public class Calculator {
    private static final Number NUMBER_ZERO = new Number("0");

    public static int sum(List<Number> numbers) {
        return numbers.stream().reduce(NUMBER_ZERO, Number::add).getValue();
    }
}
