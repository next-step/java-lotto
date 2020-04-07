package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    private static final ResultView resultView = new ResultView();
    private static final InputView inputView = new InputView();
    private static LottoStore lottoStore = new LottoStore();
    private static LottoInspector lottoInspector = new LottoInspector();

    public static void main(String[] args) {
        Money myMoney = inputView.inputMoney();
        int purchaseManualCount = inputView.inputPurchaseManualCount();
        ManualLottoOrderSheet manualLottoOrderSheet = inputView.inputManualLottoNumbers(purchaseManualCount);

        PurchaseResult purchaseResult = lottoStore.purchaseLottos(myMoney, manualLottoOrderSheet);
        resultView.viewLottos(purchaseResult);

        WinningLotto winningLotto = inputView.inputWinningNumber();

        InsightResult insightResult = lottoInspector.getResult(winningLotto, purchaseResult.getAllLottos());
        resultView.viewInspect(insightResult);
        resultView.viewRateOfReturn(lottoInspector.getYield(myMoney, insightResult.getTotalRevenue()));
    }
}
