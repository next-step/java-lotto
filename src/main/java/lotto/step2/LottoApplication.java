package lotto.step2;

import lotto.step2.domain.LottoBoard;
import lotto.step2.domain.LottoBuyer;
import lotto.step2.domain.LottoGame;
import lotto.step2.domain.WinningNumber;
import lotto.step2.view.InputView;
import lotto.step2.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoBuyer lottoBuyer = LottoBuyer.of(InputView.enterLottoPurchaseAmount());
        ResultView.printPurchaseAmount(lottoBuyer.getLottoQuantity());

        LottoGame lottoGame = LottoGame.of(lottoBuyer.getLottoQuantity());
        ResultView.printLottos(lottoGame.getLottos());

        WinningNumber winningNumber = WinningNumber.of(InputView.enterWinningNumbers());
        LottoBoard lottoBoard = lottoGame.calculateWinnings(winningNumber);

        ResultView.printLottoResult(lottoBoard);
    }
}
