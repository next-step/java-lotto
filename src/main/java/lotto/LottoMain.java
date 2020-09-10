package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;

public class LottoMain {

    public static void main(String[] args) {

        LottoController lottoController = new LottoController();

        int purchaseAmt = InputView.getPurchaseAmount();
        lottoController.purchaseLotto(purchaseAmt);

        int purchaseLottoCount = lottoController.getLottoCount();
        ResultView.viewPurchaseLottoCount(purchaseLottoCount);
        ResultView.viewLottoNumber(lottoController.getLottos());
        lottoController.checkWinningNumeber((ArrayList)InputView.getWinningNumbers());
        LottoResult lottoResult = lottoController.getLottoResult();
        ResultView.viewLottoResult(lottoResult);
    }
}
