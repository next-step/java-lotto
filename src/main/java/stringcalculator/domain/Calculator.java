package stringcalculator.domain;

import java.util.List;

public class Calculator {

    public static Calculator calculator = new Calculator();

    private Calculator() {

    }

    public int calculate(final List<Integer> numbers) {
        return numbers.stream().mapToInt(number -> number).sum();
    }

}
