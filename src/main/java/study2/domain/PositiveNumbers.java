package study2.domain;

import java.util.List;

public class PositiveNumbers {

    private final List<PositiveNumber> numbers;

    private PositiveNumbers(List<PositiveNumber> numbers) {
        this.numbers = numbers;
    }

    public static PositiveNumbers of(String[] stringNumbers) {
        return null;
    }

    public static PositiveNumbers of(List<String> stringNumbers) {
        return null;
    }

    public int sum() {
        return 0;
    }
}
