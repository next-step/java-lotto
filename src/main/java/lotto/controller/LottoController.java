package lotto.controller;

import lotto.domain.LottoBuyer;
import lotto.domain.LottoGame;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        int lottoPurchaseAmount = InputView.enterLottoPurchaseAmount();
        int lottoManualCount = InputView.enterLottoPurchaseManualCount();

        LottoBuyer lottoBuyer = LottoBuyer.of(lottoPurchaseAmount, lottoManualCount);
        List<String> lottoList = InputView.enterLottoPurchaseManuals(lottoManualCount);
        ResultView.printPurchaseAmount(lottoBuyer, lottoList);

        LottoGame lottoGame = LottoGame.of(lottoBuyer.getLottoQuantity(), lottoList);
        ResultView.printLottos(lottoGame.getLottos());

        WinningNumber winningNumber = WinningNumber.of(InputView.enterWinningNumbers(), InputView.enterBonusBall());
        lottoGame.calculateWinnings(winningNumber);
        ResultView.printLottoResult(lottoGame.getLottoBoard());
    }
}
