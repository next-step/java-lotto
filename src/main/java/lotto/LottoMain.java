package lotto;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        Lottos lottos = new Lottos(purchaseAmount);

        ResultView.printPurchaseLotto(lottos);

        String inputLine = InputView.getWinningNumber();
        WinningNumber winningNumber = new WinningNumber(Parser.parse(Split.splitDelimiter(inputLine)));

        Statistics statistics = new Statistics(lottos.winningResults(winningNumber));

        ResultView.printStatistics(statistics);
        ResultView.printYield(statistics, purchaseAmount);
    }
}
