package step2.domain;

import step2.domain.lotto.*;
import step2.domain.rank.RankType;
import views.LottoContainerFormatter;

import java.util.List;

public class LottoGame {
    private final LottoCount lottoCount;
    private final LottoGenerator lottoGenerator;
    private final LottoContainer purchasedLotto;

    public LottoGame(LottoCount lottoCount, LottoGenerator lottoGenerator) {
        this.lottoCount = lottoCount;
        this.lottoGenerator = lottoGenerator;
        this.purchasedLotto = generatelottoContainer();
    }

    public LottoGameResult play(List<Integer> winningNumbers, Integer bonusNumber) {
        Lotto lotto = new Lotto(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        List<RankType> ranks = this.purchasedLotto.checkWinningResults(winningLotto);
        return new LottoGameResult(ranks);
    }

    private LottoContainer generatelottoContainer() {
        return lottoCount.generateLottoContainer(lottoGenerator);
    }

    public String purchasedLottosAsString() {
        LottoContainerFormatter lottoContainerFormatter = new LottoContainerFormatter(purchasedLotto);
        return lottoContainerFormatter.lottosAsString();
    }
}
