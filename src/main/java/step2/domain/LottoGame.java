package step2.domain;

import step2.domain.lotto.*;
import step2.domain.rank.Rank;

import java.util.List;

public class LottoGame {
    private final LottoCount lottoCount;
    private final LottoFactory lottoFactory;
    private final LottoContainer purchasedLotto;

    public LottoGame(LottoCount lottoCount, LottoFactory lottoFactory) {
        this.lottoCount = lottoCount;
        this.lottoFactory = lottoFactory;
        this.purchasedLotto = generatelottoContainer();
    }

    public LottoGameResult play(WinningLotto winningLotto) {
        List<Rank> ranks = this.purchasedLotto.checkWinningResults(winningLotto);
        return new LottoGameResult(ranks);
    }

    private LottoContainer generatelottoContainer() {
        return lottoCount.generateLottoContainer(lottoFactory);
    }

    @Override
    public String toString() {
        return purchasedLotto.toString();
    }
}
