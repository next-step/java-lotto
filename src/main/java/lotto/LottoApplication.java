package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rewards;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        int initialAmount = InputView.inputLottoPurchaseAmount();
        int count = Lotto.calculateLottoCount(initialAmount);
        ResultView.printLottoCount(count);
        Lottos lottos = new Lottos(count);
        ResultView.printLottos(lottos);

        String winningNumber = InputView.inputWinningNumber();
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber);
        int bonusNumber = InputView.inputBonusNumber();
        ResultView.printResultOverview();

        Rewards result = lottos.getResult(winningNumbers, bonusNumber);
        ResultView.printResult(initialAmount, result);
    }
}
