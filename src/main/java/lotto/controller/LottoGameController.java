package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public static void main(String[] args) {

        PurchaseMoney purchaseMoney = new PurchaseMoney(InputView.askPurchaseAmount());
        OutputView.printCount(purchaseMoney.getLottoCount());

        LottoGame lottoGame = LottoSeller.buyLottoGame(purchaseMoney);
        OutputView.printLottoGame(lottoGame);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.askWinnerNumbers());

        LottoResult lottoResult = lottoGame.getWinningResult(winningNumbers);
        OutputView.printResult(lottoResult);
        OutputView.printEarningRate(purchaseMoney, lottoResult);

    }
}
