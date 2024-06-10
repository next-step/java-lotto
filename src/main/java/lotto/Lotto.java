package lotto;

import java.util.List;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int NUMBERS_LENGTH = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validation(numbers);
        this.numbers = numbers;
    }

    private void validation(List<Integer> numbers) {
        if (numbers == null || numbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
