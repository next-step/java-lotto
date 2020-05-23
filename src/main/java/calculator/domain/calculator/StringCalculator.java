package calculator.domain.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator implements Calculator{

    List<Number> numbers;

    public StringCalculator(String[] texts) {
        this.numbers = Arrays.stream(texts)
                .map(Number::new)
                .collect(Collectors.toList());
    }

    @Override
    public int sum() {
        return 0;
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
