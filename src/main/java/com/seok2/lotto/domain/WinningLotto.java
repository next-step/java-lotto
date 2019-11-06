package com.seok2.lotto.domain;

import com.seok2.lotto.exception.DuplicateLottoNumberException;

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
            throw new DuplicateLottoNumberException();
        }
    }

    public static WinningLotto of(Lotto lotto, LottoNumber bonus) {
        return new WinningLotto(lotto, bonus);
    }

    public Rank check(Lotto lotto) {
        return Rank.find(lotto.match(this.lotto), lotto.contains(this.bonus));
    }
}
