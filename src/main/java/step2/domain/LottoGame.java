package step2.domain;

import step2.domain.lotto.*;
import step2.domain.rank.RankType;
import views.LottoContainerFormatter;

import java.util.List;

public class LottoGame {
    private final LottoPurchaseManager lottoPurchaseManager;
    private final LottoGenerator lottoGenerator;
    private final LottoContainer purchasedLotto;

    public LottoGame(LottoPurchaseManager lottoPurchaseManager, LottoGenerator lottoGenerator) {
        this.lottoPurchaseManager = lottoPurchaseManager;
        this.lottoGenerator = lottoGenerator;
        this.purchasedLotto = generateAutolottoContainer();
    }

    public LottoGameResult play(List<Integer> winningNumbers, Integer bonusNumber) {
        Lotto lotto = new Lotto(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        List<RankType> ranks = this.purchasedLotto.checkWinningResults(winningLotto);
        return new LottoGameResult(ranks);
    }

    private LottoContainer generateAutolottoContainer() {
        return lottoPurchaseManager.generateAutoLottoContainer(lottoGenerator);
    }

    public String purchasedLottosAsString() {
        LottoContainerFormatter lottoContainerFormatter = new LottoContainerFormatter(purchasedLotto);
        return lottoContainerFormatter.lottosAsString();
    }
}
