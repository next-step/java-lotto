package com.nextstep.lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.bonusNumber = LottoNumber.of(bonusNumber);
        if (lotto.contains(this.bonusNumber)) {
            throw new IllegalArgumentException("보너스 넘버는 당첨 번호에 포함될 수 없습니다.");
        }
        this.lotto = lotto;
    }

    public long matchedCount(Lotto collectedLotto) {
        return collectedLotto.matchedCount(lotto);
    }

    public boolean checkBonusNumber(Lotto collectedLotto) {
        return collectedLotto.contains(bonusNumber);
    }
}
