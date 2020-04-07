package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.math.BigDecimal;
import java.util.List;

public class LottoApplication {
    private static final ResultView resultView = new ResultView();
    private static final InputView inputView = new InputView();
    private static LottoStore lottoStore = new LottoStore();

    public static void main(String[] args) {
        Money myMoney = inputView.inputMoney();
        int purchaseManualCount = inputView.inputPurchaseManualCount();
        ManualLottoOrderSheet manualLottoOrderSheet = inputView.inputManualLottoNumbers(purchaseManualCount);

        PurchaseResult purchaseResult = lottoStore.purchaseLottos(myMoney, manualLottoOrderSheet);
        resultView.viewLottos(purchaseResult);

        WinningLotto winningLotto = inputView.inputWinningNumber();

        InsightResult insightResult = getInsightResult(winningLotto, purchaseResult.getAllLottos());
        insightYield(myMoney, insightResult);
    }

    private static InsightResult getInsightResult(WinningLotto winningLotto, List<Lotto> lottos) {
        LottoInspector lottoInspector = new LottoInspector();
        InsightResult result = lottoInspector.getResult(winningLotto, lottos);

        resultView.viewInspect(result);

        return result;
    }

    private static LottoInspector insightYield(Money money, InsightResult insightResult) {
        LottoInspector lottoInspector = new LottoInspector();
        int totalRevenue = insightResult.getTotalRevenue();
        BigDecimal yield = lottoInspector.getYield(money, totalRevenue);

        resultView.viewInsight(yield);

        return lottoInspector;
    }
}
