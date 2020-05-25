package calculator.domain;

import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer getNumbersSum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
