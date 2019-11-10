package lotto;

import lotto.domain.LottoGame;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int money = InputView.inputMoney();
        int selfNumberCount = InputView.inputSelfNumberCount();
        List<String> selfNumbers = InputView.inputSelfNumber(selfNumberCount);

        LottoGame lottoGame = new LottoGame(money, selfNumbers);
        OutputView.printGameCount(lottoGame.lottoSize(), selfNumberCount);
        OutputView.printLottos(lottoGame.getLottos());

        String winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        OutputView.printResult(lottoGame.result(winningLotto));
    }
}
