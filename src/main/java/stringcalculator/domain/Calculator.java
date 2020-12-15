package stringcalculator.domain;

import stringcalculator.utils.Parser;

import java.util.Arrays;

public class Calculator {
    private static final int NUMBER_INITIAL = 0;
    private final String[] numbers;
    private final Sum sum;

    public Calculator(String[] numbers) {
        this.numbers = numbers;
        this.sum = new Sum(NUMBER_INITIAL);
    }

    public int add() {
        Arrays.stream(numbers).mapToInt(Parser::parse).forEach(sum::add);

        return sum.getSum();
    }
}
