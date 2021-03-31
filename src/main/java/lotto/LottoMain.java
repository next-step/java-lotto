package lotto;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        Lottos lottos = new Lottos(purchaseAmount);

        ResultView.printPurchaseLotto(lottos);

        String inputWinningNumber = InputView.getWinningNumber();
        String inputBonusNumber = InputView.getBonusNumber();

        WinningNumber winningNumber = new WinningNumber(Parser.parse(Split.splitDelimiter(inputWinningNumber))
                , Integer.parseInt(inputBonusNumber));

        Statistics statistics = new Statistics(lottos.winningResults(winningNumber));

        ResultView.printStatistics(statistics);
        ResultView.printYield(statistics, purchaseAmount);
    }
}
