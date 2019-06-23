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
        String wonBonusNumbers = InputView.askWonBonusNumbers();
        WonNumbers wonNumbers = new WonNumbers(wonNormalNumbers, wonBonusNumbers);
        Statistics statistics = new Statistics(wonNumbers, lottos);
        ResultView.printStatistics(statistics);
    }
}
