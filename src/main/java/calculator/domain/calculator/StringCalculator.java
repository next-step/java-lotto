package calculator.domain.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator implements Calculator {
    private static final Number ZERO = new Number(0);

    List<Number> numbers;

    public StringCalculator(String[] texts) {
        this.numbers = stringToNumber(texts);
    }

    private List<Number> stringToNumber(String[] texts) {
        return Arrays.stream(texts)
                .map(Number::new)
                .collect(Collectors.toList());
    }

    @Override
    public int sum() {
        return numbers.stream().reduce(ZERO, Number::add).getNumber();
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
