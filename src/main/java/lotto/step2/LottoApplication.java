package lotto.step2;

import lotto.step2.domain.LottoBoard;
import lotto.step2.domain.LottoGame;
import lotto.step2.domain.WinningNumber;
import lotto.step2.view.InputView;
import lotto.step2.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        int lottoAmount = InputView.enterLottoPurchaseAmount() / 1000;
        ResultView.printPurchaseAmount(lottoAmount);

        LottoGame lottoGame = LottoGame.of(lottoAmount);
        ResultView.printLottos(lottoGame.getLottos());

        WinningNumber winningNumber = WinningNumber.of(InputView.enterWinningNumbers().split(", "));
        LottoBoard lottoBoard = lottoGame.calculateWinnings(winningNumber);
    }
}
