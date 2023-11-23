package lottosecond.domain;

import lottosecond.domain.lotto.Lotto;
import lottosecond.domain.lotto.LottoNumber;

public class WinningCondition {

    private final Lotto lotto;
    private final LottoNumber bonusBall;

    public WinningCondition(Lotto lotto, LottoNumber bonusBall) {
        this.lotto = lotto;

        if (lotto.hasLottoNumber(bonusBall)) {
            throw new IllegalArgumentException("지난 주 당첨 번호와 동일합니다.");
        }
        this.bonusBall = bonusBall;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}
