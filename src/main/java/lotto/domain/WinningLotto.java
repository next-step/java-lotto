package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public WinningLotto(Integer bonusNumber) {
        this(new ArrayList<>(), bonusNumber);
    }

    public WinningLotto(List<Integer> numbers) {
        this(numbers, 0);
    }

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
        validateIfNotNull();
        validateIfBonusNumberNotInNumbers();
    }

    private void validateIfNotNull() {
        if (numbers == null || bonusNumber == null) throw new IllegalArgumentException();
    }

    private void validateIfBonusNumberNotInNumbers() {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public void saveMatchInfo(LottoNumber lottoNumber, Match match) {
        int matchCount = getMatchCount(lottoNumber);
        boolean bonusContains = isBonusContains(lottoNumber);
        match.save(matchCount, bonusContains);
    }

    public int getMatchCount(LottoNumber lottoNumber) {
        return (int) this.numbers.stream()
                .filter(lottoNumber::contains)
                .count();
    }

    public boolean isBonusContains(LottoNumber lottoNumber) {
        return lottoNumber.contains(this.bonusNumber);
    }
}
