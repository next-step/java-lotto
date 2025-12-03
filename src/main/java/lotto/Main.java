package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        long price = InputView.initLottoPrice();
        LottoGame lottoGame = new LottoGame(price);
        ResultView.printLottos(lottoGame);

        WinningLotto winningLotto = new WinningLotto(InputView.initWinningLotto(), InputView.initBonusNumber());
        LottoResult result = lottoGame.findWinner(winningLotto);
        ResultView.printResult(result, lottoGame);

    }
}
