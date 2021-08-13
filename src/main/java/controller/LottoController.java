package controller;

import domain.LottoManager;
import view.InputView;
import view.ResultView;

public class LottoController {

    public static void startLotto() {
        int purchaseAmount = InputView.enterPurchaseAmount();
        ResultView.purchaseResult(LottoManager.getPurchaseLottoCount(purchaseAmount));
        LottoManager lottoManager = new LottoManager(purchaseAmount);
        ResultView.lottoNumberResult(lottoManager.getLottos().getLottoList());

        System.err.println("지난 주 당첨 번호를 입력해 주세요.");
        lottoManager.makeWinningLotto();
    }
}
