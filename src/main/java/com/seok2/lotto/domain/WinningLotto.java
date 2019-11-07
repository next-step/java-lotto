package com.seok2.lotto.domain;

import com.seok2.lotto.exception.LottoDuplicateNumberException;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonus;

    private WinningLotto(Lotto lotto, LottoNumber bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(Lotto lotto, LottoNumber bonus) {
        if (lotto.contains(bonus)) {
            throw new LottoDuplicateNumberException();
        }
    }

    public static WinningLotto of(Lotto lotto, LottoNumber bonus) {
        return new WinningLotto(lotto, bonus);
    }

    Rank check(Lotto lotto) {
        return lotto.check(this.lotto, this.bonus);
    }
}
