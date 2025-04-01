package step2.domain;

import step2.domain.lotto.*;
import step2.domain.rank.RankType;
import views.LottoContainerFormatter;

import java.util.List;

public class LottoGame {
    private final LottoCount lottoCount;
    private final LottoRule lottoRule;
    private final LottoContainer purchasedLotto;

    public LottoGame(LottoCount lottoCount, LottoRule lottoRule) {
        this.lottoCount = lottoCount;
        this.lottoRule = lottoRule;
        this.purchasedLotto = generatelottoContainer();
    }

    public LottoGameResult play(List<Integer> winningNumbers, Integer bonusNumber) {
        Lotto lotto = new Lotto(winningNumbers, lottoRule);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        List<RankType> ranks = this.purchasedLotto.checkWinningResults(winningLotto);
        return new LottoGameResult(ranks);
    }

    private LottoContainer generatelottoContainer() {
        return lottoCount.generateLottoContainer(lottoRule);
    }

    public String purchasedLottosAsString() {
        LottoContainerFormatter lottoContainerFormatter = purchasedLotto.generateFormatter();
        return lottoContainerFormatter.lottosAsString();
    }
}
