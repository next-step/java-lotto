package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LottoRun {
    private static final ResultView resultView = new ResultView();
    private static final InputView inputView = new InputView();
    private static LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        Money myMoney = getMonney();

        List<Lotto> myLottos = purchaseLottos(myMoney);

        WinningLotto winningLotto = getWinningLotto();

        InsightResult insightResult = getInsightResult(winningLotto, myLottos);
        insightYield(myMoney, insightResult);
    }

    private static Money getMonney() {
        int money = inputView.inputMoney();
        return new Money(money);
    }

    private static List<Lotto> purchaseLottos(Money money) {
        int purchaseManualCount = inputView.inputPurchaseManualCount();
        PurchaseResult manualPurchaseResult = purchaseManualLotto(money, purchaseManualCount);
        PurchaseResult automaticPurchaseResult = purchaseAutomaticLotto(money.payed(manualPurchaseResult.getPayedMoney()));

        resultView.viewPurchaseCount(manualPurchaseResult.getPurchasedLottos(), automaticPurchaseResult.getPurchasedLottos());

        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manualPurchaseResult.getPurchasedLottos());
        lottos.addAll(automaticPurchaseResult.getPurchasedLottos());

        resultView.viewLottos(lottos);

        return lottos;
    }

    private static PurchaseResult purchaseAutomaticLotto(Money money) {
        PurchaseResult automaticPurchaseResult = lottoMachine.purchaseAutomaticLottos(money);
        return automaticPurchaseResult;
    }

    private static PurchaseResult purchaseManualLotto(Money money, int purchaseManualCount) {
        if (purchaseManualCount > 0) {
            ManualLottoOrderSheet manualLottoOrderSheet = inputView.inputManualLottoNumbers(purchaseManualCount);
            return lottoMachine.purchaseManualLottos(money, manualLottoOrderSheet);
        }
        return new PurchaseResult();
    }

    private static WinningLotto getWinningLotto() {
        int[] winningNumbers = inputView.inputWinningNumber();
        int bonusNumber = inputView.inputBonusNumber();

        return new WinningLotto(winningNumbers, bonusNumber);
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
