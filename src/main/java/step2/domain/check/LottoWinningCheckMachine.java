package step2.domain.check;

import step2.domain.lotto.Lotto;

public final class LottoWinningCheckMachine {

    private final Lotto winningLotto;

    private LottoWinningCheckMachine(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public static LottoWinningCheckMachine of(Lotto winningLotto) {
        return new LottoWinningCheckMachine(winningLotto);
    }

}
