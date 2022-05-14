package lotto.domain;

import lotto.ui.InputView;
import lotto.ui.ResultView;

public class App {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputView.getPrice(), InputView.getManualLottoCount());

        UserLottos userLottos = lottoGame.buyLotto(InputView.getManualLottos(lottoGame.getManualBuyCount()));
        ResultView.printBuyQuantityMessage(lottoGame.getMaxPurchasableQuantity(), lottoGame.getManualBuyCount());
        ResultView.printBuyLottoNumbers(userLottos.getBuyLottos());

        WinningLotto winningLottoNumber = new WinningLotto(InputView.getWinningNumber(), InputView.getBonusNumber());

        ResultView.printWinningTitleAndResults(userLottos.getWinningResults(winningLottoNumber));
        ResultView.printReturnRate(lottoGame.getReturnRate(winningLottoNumber, userLottos));
    }
}
