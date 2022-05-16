package lotto;

import lotto.domain.LottoGame;
import lotto.domain.WinningLotto;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class App {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputView.getPrice(), InputView.getManualLottoCount());
        lottoGame.buyLotto(InputView.getManualLottos(lottoGame.getManualBuyCount()));

        ResultView.printBuyQuantityMessage(lottoGame.getManualBuyCount(), lottoGame.getAutoBuyCount());
        ResultView.printBuyLottoNumbers(lottoGame.getUserLottos());

        WinningLotto winningLottoNumber = new WinningLotto(InputView.getWinningNumber(), InputView.getBonusNumber());

        ResultView.printWinningTitleAndResults(lottoGame.getWinningResults(winningLottoNumber));
        ResultView.printReturnRate(lottoGame.getReturnRate(winningLottoNumber));
    }
}
