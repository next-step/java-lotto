package stringcalculator.domain;

import java.util.List;

public class Calculator {

    public static Calculator calculator = new Calculator();

    private Calculator() {

    }

    public int calculate(List<String> numbers) {
        int sum = numbers.stream().mapToInt(Integer::parseInt).sum();
        return sum;
    }

}
