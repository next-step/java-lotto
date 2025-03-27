package step2.domain;

import step2.domain.lotto.LottoContainer;
import step2.domain.lotto.LottoGenerator;
import step2.domain.lotto.Rank;
import step2.domain.lotto.WinningLotto;

import java.util.List;

public class LottoGame {
    private final LottoCount lottoCount;
    private final WinningLotto winningLotto;
    private final LottoGenerator lottoGenerator;

    public LottoGame(int purchaseAmount, int lottoPrice, WinningLotto winningLotto, LottoGenerator lottoGenerator) {
        if (isValid(purchaseAmount, lottoPrice)) {
            String validationMessage = String.format("로또 구입 금액은 %d원 이상이어야 하며 %d원 단위로 가능합니다.",
                    lottoPrice, lottoPrice);
            throw new IllegalArgumentException(validationMessage);
        }
        this.lottoGenerator = lottoGenerator;
        this.lottoCount = new LottoCount(purchaseAmount, lottoPrice);
        this.winningLotto = winningLotto;
    }

    public LottoGameResult play() {
        LottoContainer lottoContainer = generatelottoContainer();
        List<Rank> ranks = lottoContainer.checkWinningResults(winningLotto);
        return new LottoGameResult(ranks);
    }

    private LottoContainer generatelottoContainer() {
        return lottoCount.generateLottoContainer(lottoGenerator);
    }

    private boolean isValid(int purchaseAmount, int lottoPrice) {
        return purchaseAmount < lottoPrice || purchaseAmount % lottoPrice != 0;
    }
}
