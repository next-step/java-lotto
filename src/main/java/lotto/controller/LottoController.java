package lotto.controller;

import lotto.model.*;
import lotto.model.dto.LottosDto;
import lotto.model.dto.WinningResultDto;
import lotto.model.AutoLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        LottoMoney lottoMoney = new LottoMoney(InputView.readLottoMoney());
        LottoPurchaser lottoPurchaser = new LottoPurchaser(new AutoLottoGenerator());
        Lottos purChasedLotto = lottoPurchaser.purchaseLotto(lottoMoney);
        OutputView.printPurchasedResult(LottosDto.from(purChasedLotto));

        WinningLotto winningLotto = new WinningLotto(InputView.readWinningLotto(),
            InputView.readBonusBall());
        WinningResult winningResult = new WinningResult(
            purChasedLotto.calculateMatchLotto(winningLotto),
            lottoMoney);
        OutputView.printWinningResult(WinningResultDto.from(winningResult));
    }

}
