package step2.domain;

import step2.domain.lotto.LottoContainer;
import step2.domain.lotto.LottoGenerator;
import step2.domain.lotto.WinningLotto;

public class LottoGame {
    private final LottoContainer lottoContainer;
    private final WinningLotto winningLotto;
    private final LottoGenerator lottoGenerator;

    public LottoGame(int purchaseAmount, int lottoPrice, WinningLotto winningLotto, LottoGenerator lottoGenerator) {
        if (isValid(purchaseAmount, lottoPrice)) {
            String validationMessage = String.format("로또 구입 금액은 %d원 이상이어야 하며 %d원 단위로 가능합니다.",
                    lottoPrice, lottoPrice);
            throw new IllegalArgumentException(validationMessage);
        }
        this.lottoGenerator = lottoGenerator;
        this.lottoContainer = new LottoContainer(purchaseAmount / lottoPrice, lottoGenerator);
        this.winningLotto = winningLotto;
    }

    public LottoGameResult play() {
        return lottoContainer.checkWinningResults(winningLotto);
    }

    public int getLottoCount() {
        return lottoContainer.size();
    }

    private boolean isValid(int purchaseAmount, int lottoPrice) {
        return purchaseAmount < lottoPrice || purchaseAmount % lottoPrice != 0;
    }
}
