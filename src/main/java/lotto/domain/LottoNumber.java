package lotto.domain;

import java.util.List;

public class LottoNumber {
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int cacheMatchCount(List<Integer> latestWinningNumbers) {
        return Match.getCount(latestWinningNumbers, this.numbers);
    }

    public boolean isBonusContains(Integer bonusNumber){
        return Match.getCount(numbers, bonusNumber);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
