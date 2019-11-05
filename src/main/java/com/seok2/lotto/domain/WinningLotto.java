package com.seok2.lotto.domain;

public class WinningLotto {

    private static final String DUPLICATE_NUMBER_ERROR_MSG = "보너스 번호가 이미 선택 된 번호입니다.";

    private final Lotto lotto;
    private final LottoNumber bonus;

    private WinningLotto(Lotto lotto, LottoNumber bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(Lotto lotto, LottoNumber bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MSG);
        }
    }

    public static WinningLotto of(Lotto lotto, LottoNumber bonus) {
        return new WinningLotto(lotto, bonus);
    }

    public Rank check(Lotto lotto) {
        return Rank.find(lotto.match(this.lotto), lotto.contains(this.bonus));
    }
}
