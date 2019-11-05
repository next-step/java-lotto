package com.seok2.lotto.domain;

import java.util.List;

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
            throw new IllegalArgumentException("보너스 번호가 이미 선택 된 번호입니다.");
        }
    }

    public static WinningLotto of(Lotto lotto, LottoNumber bonus) {
        return new WinningLotto(lotto, bonus);
    }

    public Rank check(Lotto lotto) {
        return Rank.find(lotto.match(this.lotto), lotto.contains(this.bonus));
    }
}
