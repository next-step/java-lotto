package lotto.application;

import lotto.domain.lotto.Lotteries;
import lotto.domain.rank.WinningLotto;

public class WinningLottoRequest {
    private final Lotteries lotteries;
    private final WinningLotto winningLotto;

    private WinningLottoRequest(Lotteries lotteries, WinningLotto winningLotto) {
        this.lotteries = lotteries;
        this.winningLotto = winningLotto;
    }

    public static WinningLottoRequest of(Lotteries lotteries, WinningLotto winningLotto) {
        return new WinningLottoRequest(lotteries, winningLotto);
    }

    public Lotteries getLotteries() {
        return lotteries;
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }
}
