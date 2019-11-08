package lotto;

import lotto.domain.LottoGame;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {
    public static void main(String[] args) {
        int money = InputView.inputMoney();

        LottoGame lottoGame = new LottoGame(money);
        OutputView.printGameCount(lottoGame.lottoSize());
        OutputView.printLottos(lottoGame.getLottos());

        String winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        OutputView.printResult(lottoGame.result(winningLotto));
    }
}
