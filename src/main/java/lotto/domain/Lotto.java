package lotto.domain;

import lotto.service.NumberSelectionStrategy;

public class Lotto {
    public static final int SIZE = 6;
    private final Numbers numbers;

    public Lotto(NumberSelectionStrategy numberSelectionStrategy) {
        Numbers numbers = numberSelectionStrategy.collectNumbers(SIZE);

        checkSize(numbers);

        this.numbers = numbers;
    }

    private void checkSize(Numbers numbers) {
        if (numbers.getSize() != SIZE)
            throw new IllegalArgumentException("Numbers size wrong: " + SIZE);
    }

    public int countSameNumber(Numbers numbers) {
        return this.numbers.countSameNumber(numbers);
    }

    public Numbers getNumbers() {
        return this.numbers;
    }
}
