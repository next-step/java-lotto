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
        final Lottos lottos = purchaseLottos(countOfAutoLotto, manualLottos.getManualLottos());

        final WinningLotto winningLotto = WinningLotto.from(InputView.winningLottoPrint(), InputView.bonusNumberPrint());
        result(lottos, winningLotto, purchase);
    }

    private static ManualLottos getManualLottos(final int countOfManualLotto) {

        final List<String> manualLottoList = InputView.manualLottosPrint(countOfManualLotto);
        ManualLottosValidator.validate(countOfManualLotto, manualLottoList.size());
        return ManualLottos.from(manualLottoList);
    }

    private static Lottos purchaseLottos(final int countOfAutoLotto, final Lottos manualLottos) {

        final List<Lotto> lottos = AutoLottos.autoCreate(countOfAutoLotto);
        lottos.addAll(manualLottos.getLottos());
        final Lottos totalLottos = new Lottos(lottos);
        ResultView.autoLottoNumberPrint(totalLottos);
        return totalLottos;
    }

    private static void result(final Lottos lottos, final WinningLotto winningLotto, final Purchase purchase) {

        final WinningResult winningResult = WinningResult.init();
        winningResult.collect(lottos.match(winningLotto));
        ResultView.winningResultPrint(winningResult);
        ResultView.winningPrizeRatePrint(ProfitRate.of(winningResult.sum(), purchase));
    }
}
