package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class EqualNumbers {
    private final int equalCount;
    private final boolean bonusEqualYn;

    public EqualNumbers(Lotto lotto, WinOfLotto winOfLotto) {
        Set<Integer> winNumbers = new HashSet<>(lotto.getNumbers());
        winNumbers.retainAll(winOfLotto.getNumbers());
        equalCount = winNumbers.size();
        bonusEqualYn = winOfLotto.containBonusNumber(lotto.getNumbers());
    }

    public int getEqualCount() {
        return this.equalCount;
    }

    public boolean getBonusEqual() {
        return this.bonusEqualYn;
    }
}
