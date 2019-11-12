package lotto;

import lotto.domain.LottoGame;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int money = InputView.inputMoney();
        int selfNumberCount = InputView.inputSelfNumberCount();
        List<String> selfNumbers = InputView.inputSelfNumber(selfNumberCount);

        Lottos lottos = LottoGame.buyLottoWithSelfNumbers(money, selfNumbers);
        OutputView.printGameCount(lottos.size(), selfNumberCount);
        OutputView.printLottos(lottos.unmodifiableLottos());

        String winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        OutputView.printResult(lottos.result(winningLotto, money));
    }
}
