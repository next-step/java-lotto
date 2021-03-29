package lotto.controller;

import lotto.domain.LottoBuyer;
import lotto.domain.LottoGame;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public static void main(String[] args) {
        LottoBuyer lottoBuyer = LottoBuyer.of(InputView.enterLottoPurchaseAmount());
        ResultView.printPurchaseAmount(lottoBuyer.getLottoQuantity());

        LottoGame lottoGame = LottoGame.of(lottoBuyer.getLottoQuantity());
        ResultView.printLottos(lottoGame.getLottos());

        WinningNumber winningNumber = WinningNumber.of(InputView.enterWinningNumbers());
        lottoGame.calculateWinnings(winningNumber);
        ResultView.printLottoResult(lottoGame.getLottoBoard());
    }
}
