package step1;

import java.util.List;

public class Numbers {
    private static final int FIRST_ELEMENT_INDEX = 0;
    private final List<Integer> numbers;

    private Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Numbers of(List<Integer> numbers) {
        return new Numbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("숫자가 없습니다.");
        }
    }

    public int getFirstNumber() {
        return numbers.get(FIRST_ELEMENT_INDEX);
    }

    public int getFromIndex(int i) {
        return numbers.get(i);
    }
}
