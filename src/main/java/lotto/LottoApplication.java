package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoGame;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        int money = new InputView().getMoneyInput();

        List<Lotto> lottos = lottoGame.createLotto(money);

        ResultView resultView = new ResultView();
        resultView.printLottoCount(lottos);
        resultView.printLottos(lottos);

        List<Integer> numbers = new InputView().getWinningLottoInput();
        int bonusNumber = new InputView().getBonusNumber();
        WinningLotto winningLotto = LottoFactory.createWinningLotto(numbers, bonusNumber);

        resultView.printWinningResult(lottoGame.getRankResults(winningLotto, lottos));
        resultView.printRateOfReturn(lottoGame.calculateRateOfReturn(winningLotto, lottos));
    }
}
