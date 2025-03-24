package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rewards;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import static lotto.view.InputView.inputLottoPurchaseAmount;
import static lotto.view.InputView.printLottoCount;

public class LottoApplication {
    public static void main(String[] args) {
        int initialAmount = inputLottoPurchaseAmount();
        int count = Lotto.calculateLottoCount(initialAmount);
        printLottoCount(count);
        Lottos lottos = new Lottos(count);

        String winningNumber = InputView.inputWinningNumber();
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber);
        ResultView.printResultOverview();

        Rewards result = lottos.getResult(winningNumbers);
        ResultView.printResult(initialAmount, result);
    }
}
