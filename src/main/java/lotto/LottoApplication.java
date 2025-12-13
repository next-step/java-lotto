package lotto;

import lotto.controller.LottoMachine;
import lotto.domain.WinningLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        String purchaseAmount = InputView.getPurchaseAmount();

        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);
        Lotto lotto = lottoMachine.generate();

        ResultView.printLotto(lotto);

        String winningNumbers = InputView.getWinningNumber();
        String bonusNumber = InputView.getBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoResult result = lotto.getMatchResult(winningLotto);

        ResultView.printLottoResult(result.toString());
        ResultView.printProfit(result.getProfit());
    }
}
