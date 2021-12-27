package stringcaculator.domain;

import java.util.List;

public class StringCalculator implements Calculator{
    private static final String INITIAL_VALUE = "0";
    private final Numbers numbers;

    public StringCalculator(Numbers numbers) {
        this.numbers = numbers;
    }

    public Number calculation() {
        List<Number> numberList = this.numbers.numbers();
        Number result = new Number(new ValidationValueFactory().create(INITIAL_VALUE));
        for (Number number: numberList) {
            result = result.sum(number);
        }
        return result;
    }
}