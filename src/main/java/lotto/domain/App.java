package lotto.domain;

import lotto.ui.InputView;
import lotto.ui.ResultView;

public class App {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputView.getPrice());
        lottoGame.auto();
        ResultView.printBuyQuantityMessage(lottoGame.getMaxPurchasableQuantity());
        ResultView.printBuyLottoNumbers(lottoGame.getBuyLottoNumbers());

        WinningLotto winningLottoNumber = new WinningLotto(InputView.getWinningNumber(), InputView.getBonusNumber());

        ResultView.printWinningTitleAndResults(lottoGame.getLottoGameResults(winningLottoNumber));
        ResultView.printReturnRate(lottoGame.getReturnRate(winningLottoNumber));
    }
}
