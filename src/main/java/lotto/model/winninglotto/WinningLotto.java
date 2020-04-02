package lotto.model.winninglotto;

import lotto.model.lotto.LottoNumber;
import lotto.model.lotto.Lotto;

public class WinningLotto {
    private Lotto winningLotto;
    private BonusBall bonusBall;

    public WinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public WinningLotto(Lotto winningLotto, BonusBall bonusBall) {
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return winningLotto
                .contains(lottoNumber);
    }

    public BonusBall getBonusNumber() {
        return bonusBall;
    }

    public static WinningLotto of(Lotto winningLotto) {
        return new WinningLotto(winningLotto);
    }

    public static WinningLotto of(Lotto winningLotto, BonusBall bonusBall) {
        return new WinningLotto(winningLotto, bonusBall);
    }
}