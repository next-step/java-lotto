package lotto.model;

import java.util.List;

import static lotto.util.MessageUtil.WARNING_BONUS_BALL_NOT_IN_LOTTO;

public class WinningLotto {
    private Lotto lotto;
    private LottoNumber bonusBall;

    public WinningLotto(Lotto lotto, LottoNumber bonusBall) {
        validateBonusBallNotInLotto(lotto, bonusBall);
        this.lotto = lotto;
        this.bonusBall = bonusBall;
    }

    private void validateBonusBallNotInLotto(Lotto lotto, LottoNumber bonusBall) {
        if (lotto.hasBonusBallNumber(bonusBall)) {
            throw new IllegalArgumentException(WARNING_BONUS_BALL_NOT_IN_LOTTO);
        }
    }

    public List<LottoNumber> getLotto() {
        return lotto.getLottoNumbers();
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}