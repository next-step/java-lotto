package calculator;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(List<String> textNumbers) {
        this.numbers = rapping(textNumbers);
    }

    private List<Number> rapping(List<String> stringNumbers) {
        return stringNumbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public int getResult() {
        return this.numbers.stream()
                .mapToInt(Number::getNumber)
                .sum();
    }
}
