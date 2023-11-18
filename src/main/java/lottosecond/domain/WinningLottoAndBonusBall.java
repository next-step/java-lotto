package lottosecond.domain;

import lottosecond.domain.lotto.Lotto;

public class WinningLottoAndBonusBall {

    private final Lotto lotto;
    private final BonusBall bonusBall;

    public WinningLottoAndBonusBall(Lotto lotto, BonusBall bonusBall) {
        this.lotto = lotto;

        if (bonusBall.isDuplicateWithLastWinningLottoNumber(lotto)) {
            throw new IllegalArgumentException("지난 주 당첨 번호와 동일합니다.");
        }
        this.bonusBall = bonusBall;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusBall getBonusBall() {
        return bonusBall;
    }
}
