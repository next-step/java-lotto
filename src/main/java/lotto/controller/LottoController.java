package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.LottoGame;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        LottoBuyer lottoBuyer = LottoBuyer.of(InputView.enterLottoPurchaseAmount());
        List<String> lottoList = InputView.enterLottoPurchaseManualCount();
        ResultView.printPurchaseAmount(lottoBuyer, lottoList);

        LottoGame lottoGame = LottoGame.of(lottoBuyer.getLottoQuantity(), lottoList);
        ResultView.printLottos(lottoGame.getLottos());

        WinningNumber winningNumber = WinningNumber.of(InputView.enterWinningNumbers(), InputView.enterBonusBall());
        lottoGame.calculateWinnings(winningNumber);
        ResultView.printLottoResult(lottoGame.getLottoBoard());
    }
}
