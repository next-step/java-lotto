package lotto.domain;

import java.util.Optional;

public class WinnerLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinnerLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Optional<WinnerType> findWinnerType(Lotto target) {
        int count = 0;
        boolean isMatchBonus = false;
        for (Integer number : target.getNumbers()) {
            count = lotto.contains(number) ? count + 1 : count;
            isMatchBonus = (number == bonusNumber) || isMatchBonus;
        }

        return WinnerType.findByCount(count, isMatchBonus);
    }
}
