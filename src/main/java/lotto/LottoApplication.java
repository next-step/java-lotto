package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {

        final Purchase purchase = Purchase.from(InputView.purchasePrint());
        final long availableTickets = purchase.available();
        ResultView.availablePurchasePrint(availableTickets);

        Lottos lottos = new Lottos(AutoLottos.autoCreate(availableTickets));
        ResultView.autoLottoNumberPrint(lottos);
        final WinningLotto winningLotto = WinningLotto.from(InputView.winnerNumberPrint(), InputView.bonusNumberPrint());

        final WinningResult winningResult = WinningResult.init();
        winningResult.collect(lottos.match(winningLotto));
        ResultView.winningResultPrint(winningResult);
        ResultView.winningPrizeRatePrint(ProfitRate.of(winningResult.sum(), purchase));
    }
}
