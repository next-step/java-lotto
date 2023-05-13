package lotto.domain;

import java.util.List;

public class WinLotto {
    private final Numbers numbers;
    private final Integer bonusNumber;

    public WinLotto(Numbers numbers) {
        this(numbers, null);
    }

    public WinLotto(Numbers numbers, Integer bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public WinLotto(List<Integer> numbers, Integer bonusNumber) {
        this(new Numbers(numbers), bonusNumber);
    }

    public Numbers numbers() {
        return numbers;
    }

    public Integer bonusNumber() {
        return bonusNumber;
    }

    public Rank checkRank(Lotto lotto) {
        int matchCount = this.numbers.countContains(lotto.numbers());
        boolean matchBounus = lotto.numbers().contains(this.bonusNumber);
        return Rank.of(matchCount, matchBounus);
    }
}
