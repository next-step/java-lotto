package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (!isSatisfied(numbers.size())) {
            throw new IllegalArgumentException("숫자가 부족합니다");
        }
    }

    private boolean isSatisfied(int count) {
        return count == NUMBER_COUNT;
    }

    public int matches(List<Integer> winningNumbers) {
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
