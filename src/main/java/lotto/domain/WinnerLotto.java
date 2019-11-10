package lotto.domain;

import java.util.Optional;

public class WinnerLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinnerLotto(Lotto lotto, int bonusNumber) {
        checkDuplicate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void checkDuplicate(Lotto lotto, int bonusNumber) {
        if(lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("lotto 당첨 번호와 보너스볼 번호는 같을 수 없습니다.");
        }
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
