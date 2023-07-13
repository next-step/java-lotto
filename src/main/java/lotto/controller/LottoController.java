package lotto.controller;

import lotto.model.*;
import lotto.model.util.AutoLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        LottoMoney lottoMoney = new LottoMoney(InputView.readLottoMoney());
        LottoPurchaser lottoPurchaser = new LottoPurchaser(new AutoLottoGenerator());
        PurChasedLotto purChasedLotto = lottoPurchaser.purchaseLotto(lottoMoney);
        OutputView.printPurchasedResult(purChasedLotto);

        WinningLotto winningLotto = new WinningLotto(InputView.readWinningLotto(),
            InputView.readBonusBall());
        WinningResult winningResult = new WinningCalculator().calculate(winningLotto,
            purChasedLotto);
        OutputView.printWinningResult(WinningResultDto.of(winningResult, lottoMoney));
    }

}
