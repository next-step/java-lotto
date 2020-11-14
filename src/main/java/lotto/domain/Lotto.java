package lotto.domain;

public class Lotto {

    private final Numbers numbers;
    private final NumberSelectionStrategy numberSelectionStrategy;

    public Lotto(NumberSelectionStrategy numberSelectionStrategy) {
        this.numberSelectionStrategy = numberSelectionStrategy;
        this.numbers = numberSelectionStrategy.collectNumbers();
    }

    public Numbers getNumbers() {
        return this.numbers;
    }
}
