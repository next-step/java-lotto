package lottos.controller;

import lottos.domain.Lotto;
import lottos.domain.Lottos;


public class LottoConsoleController {

    public Lottos buy(final int purchaseAmount) {
        return new Lottos(purchaseAmount);
    }

    public Lotto lastWeeksWinningLotto(final String lastWeeksNumbersText) {
        return new Lotto(lastWeeksNumbersText);
    }
}
