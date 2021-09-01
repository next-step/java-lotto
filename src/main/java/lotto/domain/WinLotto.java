package lotto.domain;

import static lotto.domain.Rank.valueOf;

public class WinLotto {

    private static final String LOTTO_BONUS_DUPLICATE_ERROR_MESSAGE = "로또의 번호와 보너스 번호는 중복될 수 없다.";

    private final Lotto lotto;

    private final Number bonus;

    public WinLotto(Lotto lotto, Number bonus) {
        checkDuplicateLottoAndBonus(lotto, bonus);

        this.lotto = lotto;
        this.bonus = bonus;
    }

    private static void checkDuplicateLottoAndBonus(Lotto lotto, Number bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException(LOTTO_BONUS_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public Lotto lotto() {
        return lotto;
    }

    public Number bonus() {
        return bonus;
    }

    public Rank calculateRank(Lotto lotto) {
        int winCount = lotto.calculateWinCount(this.lotto);
        boolean isBonus = lotto.contains(bonus);
        return valueOf(winCount, isBonus);
    }

}
