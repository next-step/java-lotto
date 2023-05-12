package lotto.domain;

import java.util.Set;

public class WinNumbers {
    private final Lotto winNumbers;
    private final LottoNumber bonus;

    public WinNumbers(Set<Integer> numbers, int bonus) {
        this.winNumbers = new Lotto(numbers);
        this.bonus = LottoNumber.of(bonus);
    }

    public long getMatchCount(Lotto lotto) {
        return lotto.getMatchCount(this.winNumbers);
    }

    public boolean isBonusIncludedIn(Lotto lotto) {
        return lotto.contains(this.bonus);
    }
}
