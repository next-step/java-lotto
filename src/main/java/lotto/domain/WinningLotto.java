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
