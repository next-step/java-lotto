package lotto;

import lotto.ui.InputView;
import lotto.ui.ResultView;

public class App {
    public static void main(String[] args) {
        String price = InputView.getPrice();
        LottoGame lottoGame = new LottoGame(price);
        lottoGame.auto();
        ResultView.printBuyQuantityMessage(lottoGame.getMaxPurchasableQuantity());
        ResultView.printBuyLottoNumbers(lottoGame);

        String winningNumber = InputView.getLastWinningNumber();
        String bonusNumber = InputView.getBonusNumber();
        WinningLotto winningLottoNumber = new WinningLotto(winningNumber, bonusNumber);
        ResultView.printWinningTitle();
        ResultView.printWinningResults(lottoGame.getLottoGameResults(winningLottoNumber));
        ResultView.printReturnRate(lottoGame.getReturnRate(winningLottoNumber));
    }
}
