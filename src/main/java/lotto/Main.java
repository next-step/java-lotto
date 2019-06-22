package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    public static void main(String[] args) {

        int purchaseAmount = InputView.askPurchaseAmount();
        Lottos lottos = new Lottos(purchaseAmount);

        ResultView.printPurchasedLottoCount(lottos.getLottoCount());
        ResultView.printLottosNumber(lottos);

        LastWeekNumbers lastWeekNumbers = new LastWeekNumbers(InputView.askLastWeekNumbers());
        Statistics statistics = new Statistics(lastWeekNumbers, lottos);
        ResultView.printStatistics(statistics);
    }
}
