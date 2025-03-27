package step2.domain;

import step2.domain.lotto.*;

import java.util.List;

public class LottoGame {
    private final LottoCount lottoCount;
    private final WinningLotto winningLotto;
    private final LottoFactory lottoFactory;

    public LottoGame(int purchaseAmount, int lottoPrice, WinningLotto winningLotto, LottoFactory lottoFactory) {
        if (isValid(purchaseAmount, lottoPrice)) {
            String validationMessage = String.format("로또 구입 금액은 %d원 이상이어야 하며 %d원 단위로 가능합니다.",
                    lottoPrice, lottoPrice);
            throw new IllegalArgumentException(validationMessage);
        }
        this.lottoFactory = lottoFactory;
        this.lottoCount = new LottoCount(purchaseAmount, lottoPrice);
        this.winningLotto = winningLotto;
    }

    public LottoGameResult play() {
        LottoContainer lottoContainer = generatelottoContainer();
        List<Rank> ranks = lottoContainer.checkWinningResults(winningLotto);
        return new LottoGameResult(ranks);
    }

    private LottoContainer generatelottoContainer() {
        return lottoCount.generateLottoContainer(lottoFactory);
    }

    private boolean isValid(int purchaseAmount, int lottoPrice) {
        return purchaseAmount < lottoPrice || purchaseAmount % lottoPrice != 0;
    }
}
