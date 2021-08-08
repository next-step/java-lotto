package lottos.controller;

import lottos.domain.Lottos;
import lottos.domain.WinningLotto;


public class LottoConsoleController {

    public Lottos buy(final int purchaseAmount) {
        return new Lottos(purchaseAmount);
    }

    public WinningLotto lastWeeksWinningLotto(final String lastWeeksNumbersText, final String bonusNumberText) {
        return new WinningLotto(lastWeeksNumbersText, bonusNumberText);
    }
}
