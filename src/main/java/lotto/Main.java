package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    public static void main(String[] args) {

        int purchaseAmount = InputView.askPurchaseAmount();
        Lottos lottos = new Lottos(purchaseAmount);

        ResultView.printPurchasedLottoCount(lottos.getLottoCount());
        ResultView.printLottosNumber(lottos);

        WonNumbers wonNumbers = new WonNumbers(InputView.askWonNumbers());
        Statistics statistics = new Statistics(wonNumbers, lottos);
        ResultView.printStatistics(statistics);
    }
}
