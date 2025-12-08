package lotto;

import lotto.controller.LottoMachine;
import lotto.controller.WinningLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import lotto.util.LottoNumberParser;

public class LottoApplication {
    public static void main(String[] args) {
        String purchaseAmount = InputView.getPurchaseAmount();
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);
        Lotto lotto = lottoMachine.generate();
        ResultView.printLotto(lotto);

        String winningNumbers = InputView.getWinningNumber();
        WinningLotto winningLotto = new WinningLotto(LottoNumberParser.parse(winningNumbers));
        LottoResult result = winningLotto.getResult(lotto);
        ResultView.printLottoResult(result.toString());
        ResultView.printProfit(result.getProfit());
    }
}
