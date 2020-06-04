package com.cheolhyeonpark.lotto.domain;

import java.util.List;

public class LottoNumbers {

    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Rank getRank(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return Rank.findRank(countSameNumbersAs(winningNumbers), hasBonusNumber(bonusNumber));
    }

    private int countSameNumbersAs(WinningNumbers winningNumbers) {
        return Math.toIntExact(numbers.stream().filter(winningNumbers::anyMatch).count());
    }

    private boolean hasBonusNumber(BonusNumber bonusNumber) {
        return numbers.stream().anyMatch(bonusNumber::isMatch);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
