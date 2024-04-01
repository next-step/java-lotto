package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final List<LottoNumber> numbers;
    private final Integer bonusNumber;

    public WinningLotto(Integer bonusNumber) {
        this(new ArrayList<>(), bonusNumber);
    }

    public WinningLotto(List<LottoNumber> numbers, Integer bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
        validateIfNotNull();
        validateIfBonusNumberNotInNumbers();
    }

    private void validateIfNotNull() {
        if (numbers == null || bonusNumber == null){
            throw new IllegalArgumentException("당첨 로또 숫자들 또는 보너스 숫자가 null이 아니어야 합니다.");
        }
    }

    private void validateIfBonusNumberNotInNumbers() {
        if (numbers.contains(new LottoNumber(bonusNumber))) {
            throw new IllegalArgumentException("당첨 로또 숫자 안에 보너스 숫자가 포함되지않아야 합니다.");
        }
    }

    public void saveMatchInfo(Lotto lotto, Match match) {
        int matchCount = getMatchCount(lotto);
        boolean bonusContains = isBonusContains(lotto);
        match.save(matchCount, bonusContains);
    }

    public int getMatchCount(Lotto lotto) {
        return (int) this.numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean isBonusContains(Lotto lotto) {
        return lotto.contains(this.bonusNumber);
    }
}
