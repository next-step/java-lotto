package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.LottoResult;
import lotto.domain.LottoSeller;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public static void main(String[] args) {

        int purchaseAmount = InputView.askPurchaseAmount();
        int lottoCount = LottoSeller.getLottoCount(purchaseAmount);
        OutputView.printCount(lottoCount);

        LottoGame lottoGame = LottoSeller.buyLottoGame(lottoCount);
        OutputView.printLottoGame(lottoGame);

        WinningNumbers winningNumbers = new WinningNumbers(InputView.askWinnerNumbers());

        LottoResult lottoResult = lottoGame.getWinningResult(winningNumbers);
        OutputView.printResult(lottoResult);

    }
}
