package calculator;

import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public boolean hasNegativeNum() {
        return numbers.stream()
                .anyMatch(it -> it < 0);
    }

    public boolean hasOnlyOneNumber() {
        return numbers.size() == 1;
    }

    public int firstNumber() {
        return numbers.get(0);
    }
}
