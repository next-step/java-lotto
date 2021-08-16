package controller;

import domain.LottoManager;
import domain.ManualNumberStrategy;
import view.InputView;
import view.ResultView;

public class LottoController {

    public static void startLotto() {
        int purchaseAmount = InputView.enterPurchaseAmount();
        LottoManager lottoManager = new LottoManager(purchaseAmount);
        ResultView.purchaseResult(lottoManager.getPurchaseLottoCount(purchaseAmount));
        ResultView.lottoNumberResult(lottoManager.getLottos().getValue());

        System.err.println("지난 주 당첨 번호를 입력해 주세요.");
        lottoManager.makeWinningLotto(new ManualNumberStrategy());
        ResultView.winningResult(lottoManager.findWinningLottoResult());
        ResultView.yieldResult(lottoManager.getLottoYield(purchaseAmount));
    }
}
