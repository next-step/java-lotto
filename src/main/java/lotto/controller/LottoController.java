package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        LottoMoney lottoMoney = new LottoMoney(InputView.readLottoMoney());
        LottoPurchaser lottoPurchaser = new LottoPurchaser(new AutoLottoGenerator());

        PurChasedLottos purChasedLottos = lottoPurchaser.purchaseLotto(lottoMoney);
        OutputView.printPurchasedLottos(purChasedLottos);

        WinningLotto winningLotto = new WinningLotto(InputView.readNumbers(), InputView.readBonusBall());
        WinningResult winningResult = WinningResult.of(winningLotto, purChasedLottos);
        OutputView.printWinningResult(winningResult);
    }
}
