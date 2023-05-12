package lotto.domain;

import java.util.Set;

public class WinNumbers {
    private final Lotto winNumbers;
    private final LottoNumber bonus;

    public WinNumbers(Set<Integer> numbers, int bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 달라야 합니다");
        }
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
