package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {

        final Purchase purchase = Purchase.from(InputView.purchasePrint());
        final int countOfManualLotto = InputView.purchaseManualLottosPrint();
        final ManualLottos manualLottos = ManualLottos.of(countOfManualLotto, InputView.manualLottosPrint(countOfManualLotto));

        final Lottos lottos = new Lottos(AutoLottos.autoCreate(purchase.available(), manualLottos.count()));
        ResultView.autoLottoNumberPrint(lottos);
        final WinningLotto winningLotto = WinningLotto.from(InputView.winningLottoPrint(), InputView.bonusNumberPrint());
        lottos.add(manualLottos);

        final WinningResult winningResult = WinningResult.init();
        winningResult.collect(lottos.match(winningLotto));
        ResultView.winningResultPrint(winningResult);
        ResultView.winningPrizeRatePrint(ProfitRate.of(winningResult.sum(), purchase));
    }
}
