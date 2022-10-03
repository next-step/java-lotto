package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {

    public static void main(String[] args) {

        PurchaseMoney purchaseMoney = new PurchaseMoney(InputView.askPurchaseAmount(), InputView.askManualCount());
        List<String[]> manualNumbers = InputView.askManualNumbers(purchaseMoney.getManualCount());

        LottoGame lottoGame = LottoSeller.buyLottoGame(purchaseMoney, manualNumbers);
        OutputView.printLottoGame(lottoGame);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.askWinnerNumbers(), InputView.askBonusNumber());

        LottoResult lottoResult = lottoGame.getWinningResult(winningNumbers);
        OutputView.printResult(lottoResult);
        OutputView.printEarningRate(purchaseMoney, lottoResult);

    }
}
