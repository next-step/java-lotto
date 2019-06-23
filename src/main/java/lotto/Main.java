package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    public static void main(String[] args) {

        PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.askPurchaseAmount());
        Lottos lottos = new Lottos(purchaseAmount);

        ResultView.printPurchasedLottoCount(purchaseAmount.getPurchasedLottosCount());
        ResultView.printLottosNumber(lottos);

        String wonNormalNumbers = InputView.askWonNormalNumbers();
        String wonBousNumbers = InputView.askWonNormalNumbers();
        WonNumbers wonNumbers = new WonNumbers(InputView.askWonNormalNumbers(), InputView.askWonBonusNumbers());
        Statistics statistics = new Statistics(wonNumbers, lottos);
        ResultView.printStatistics(statistics);
    }
}
