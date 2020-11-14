package lotto.domain;

public class Lotto {

    private final Numbers numbers;
    private final NumberSelectionStrategy numberSelectionStrategy;

    public Lotto(NumberSelectionStrategy numberSelectionStrategy) {
        this.numberSelectionStrategy = numberSelectionStrategy;
        this.numbers = numberSelectionStrategy.collectNumbers();
    }

    public WinningRank checkWinningRank(Numbers numbers) {
        return WinningRank.getWinningRank(this.numbers.countSameNumber(numbers));
    }

    public Numbers getNumbers() {
        return this.numbers;
    }
}
