package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {

        final Purchase purchase = Purchase.from(InputView.purchasePrint());
        final int countOfManualLotto = InputView.purchaseManualLottosPrint();
        final ManualLottos manualLottos = getManualLottos(countOfManualLotto);

        final int countOfAutoLotto = purchase.available() - countOfManualLotto;
        final Lottos lottos = getLottos(countOfAutoLotto, manualLottos);

        final WinningLotto winningLotto = WinningLotto.from(InputView.winningLottoPrint(), InputView.bonusNumberPrint());
        result(lottos, winningLotto, purchase);
    }

    private static ManualLottos getManualLottos(final int countOfManualLotto) {

        final List<String> manualLottoList = InputView.manualLottosPrint(countOfManualLotto);
        ManualLottosValidator.validate(countOfManualLotto, manualLottoList.size());
        final ManualLottos manualLottos = ManualLottos.from(manualLottoList);
        return manualLottos;
    }

    private static Lottos getLottos(final int countOfAutoLotto, final ManualLottos manualLottos) {

        final Lottos lottos = new Lottos(AutoLottos.autoCreate(countOfAutoLotto));
        ResultView.autoLottoNumberPrint(lottos);
        lottos.add(manualLottos);
        return lottos;
    }

    private static void result(final Lottos lottos, final WinningLotto winningLotto, final Purchase purchase) {

        final WinningResult winningResult = WinningResult.init();
        winningResult.collect(lottos.match(winningLotto));
        ResultView.winningResultPrint(winningResult);
        ResultView.winningPrizeRatePrint(ProfitRate.of(winningResult.sum(), purchase));
    }
}
