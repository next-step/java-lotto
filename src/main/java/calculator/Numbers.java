package calculator;

import java.util.List;

public class Numbers {

    private final List<String> numbers;

    public Numbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public Integer getNumbersSum() {
        return numbers.stream()
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .orElseThrow(() -> {
                   throw new RuntimeException();
                });
    }
}
