package lotto;

import lotto.controller.LottoMachine;
import lotto.controller.WinningLotto;
import lotto.domain.Lotto;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import lotto.util.LottoNumberParser;

public class LottoApplication {
    public static void main(String[] args) {
        String purchaseAmount = InputView.getPurchaseAmount();
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);
        Lotto lotto = lottoMachine.generate();
        ResultView.printLottoCount(lotto.count());
        ResultView.printLottoNumbersList(lotto.toString());

        String winningNumbers = InputView.getWinningNumber();
        WinningLotto winningLotto = new WinningLotto(LottoNumberParser.parse(winningNumbers));

        ResultView.printLottoResult(winningLotto.getResult(lotto));
        ResultView.printProfit(winningLotto.getProfit(lotto));
    }
}
