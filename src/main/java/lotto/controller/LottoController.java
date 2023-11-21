package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void run() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        Purchase purchase = new Purchase(purchaseAmount, Purchase.purchaseCount(purchaseAmount));
        ResultView.showLottoCount(purchase.getCount());

        Lottos lottoList = new Lottos(Lottos.createLottos(purchase.getCount()));
        ResultView.showLottoList(lottoList);

        WinningNumbers winningNumberList = new WinningNumbers(WinningNumbers.createList(InputView.inputWinningNumbers()));
        LottoMatchNumbers lottoMatchNumbers = lottoList.matchNumbers(winningNumberList);
        LottoStatistics lottoStatistics = new LottoStatistics();
        ResultView.showLottoStatistics(lottoMatchNumbers, lottoStatistics);
        ResultView.showRate(lottoStatistics.getRate(purchase, lottoStatistics.getTotalPrize(lottoMatchNumbers)));
    }
}
