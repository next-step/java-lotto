package step2.domain;

import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoContainer;
import step2.domain.lotto.WinningLotto;
import step2.domain.rank.RankType;

import java.util.List;

public class LottoGame {
    private final LottoContainer purchasedLotto;

    public LottoGame(LottoContainer purchasedLotto) {
        this.purchasedLotto = purchasedLotto;
    }

    public LottoGameResult play(List<Integer> winningNumbers, Integer bonusNumber) {
        Lotto lotto = new Lotto(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        List<RankType> ranks = this.purchasedLotto.checkWinningResults(winningLotto);
        return new LottoGameResult(ranks);
    }

    public LottoContainer getPurchasedLotto() {
        return purchasedLotto;
    }
}
