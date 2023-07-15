package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public void run() {
        final LottoMoney lottoMoney = new LottoMoney(InputView.readMoney());
        final ManualLottoCount manualLottoCount = new ManualLottoCount(InputView.readManualCount());

        final Automatic automatic = new Automatic(lottoMoney.consume(manualLottoCount));
        final Manuals manuals = new Manuals(readManualNumbers(manualLottoCount), new LottoMoney(manualLottoCount));

        final PurChasedLottos purChasedLottos = purchaseLotto(automatic, manuals);
        OutputView.printPurchasedLottos(purChasedLottos);

        final WinningResult winningResult = computeWinningResult(purChasedLottos);
        OutputView.printWinningResult(winningResult);
    }

    private List<List<Integer>> readManualNumbers(final ManualLottoCount manualLottoCount) {
        return InputView.readManualNumbers(manualLottoCount.getManualCount());
    }

    private PurChasedLottos purchaseLotto(final Automatic automatic, final Manuals manuals) {
        final LottoPurchaser lottoPurchaser = new LottoPurchaser(new LottoFactory());
        return lottoPurchaser.purchaseLotto(automatic, manuals);
    }

    private WinningResult computeWinningResult(final PurChasedLottos purChasedLottos) {
        final WinningLotto winningLotto = new WinningLotto(InputView.readWinningNumbers(), InputView.readBonusBall());
        return WinningResult.of(winningLotto, purChasedLottos);
    }

}
