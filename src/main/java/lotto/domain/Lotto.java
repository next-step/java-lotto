package lotto.domain;

import lotto.service.NumberSelectionStrategy;

public class Lotto {
    public static final int SIZE = 6;
    private final Numbers numbers;

    public Lotto(Numbers numbers) {
        checkSize(numbers);

        this.numbers = numbers;
    }

    public Lotto(NumberSelectionStrategy numberSelectionStrategy) {
        Numbers numbers = numberSelectionStrategy.collectNumbers();

        checkSize(numbers);

        this.numbers = numbers;
    }

    private void checkSize(Numbers numbers) {
        if (numbers.getSize() != SIZE)
            throw new IllegalArgumentException("Numbers size wrong: " + SIZE);
    }

    public RankMatcher getRankMatcher(WinningLotto winningLotto) {
        int sameNumberCount = winningLotto.countSameNumber(numbers);
        boolean matchBonusNumber = winningLotto.checkBonus(numbers);
        return new RankMatcher(sameNumberCount, matchBonusNumber);
    }

    public Numbers getNumbers() {
        return this.numbers;
    }
}
