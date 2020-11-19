package lotto.domain;

import lotto.service.NumberSelectionStrategy;

public class Lotto {

    private final Numbers numbers;

    public Lotto(NumberSelectionStrategy numberSelectionStrategy) {
        this.numbers = numberSelectionStrategy.collectNumbers();
    }

    public int countSameNumber(Numbers numbers) {
        return this.numbers.countSameNumber(numbers);
    }

    public Numbers getNumbers() {
        return this.numbers;
    }
}
