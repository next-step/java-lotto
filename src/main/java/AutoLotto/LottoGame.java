package autoLotto;

import autoLotto.model.*;
import autoLotto.view.InputView;
import autoLotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoGame {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    private int purchaseAmount;
    private LottoMachine lottoMachine;

    public void run() {
        processPurchase();
        processWinning();
    }

    private void processPurchase() {
        purchaseAmount = inputView.inputPurchase();
        int numberOfManualLottos = inputView.inputManualPurchase(purchaseAmount);
        List<String> manualLottos = inputView.buyManualLottos(numberOfManualLottos);
        LottoPurchaseCount purchaseCount = new LottoPurchaseCount(purchaseAmount, numberOfManualLottos);

        lottoMachine = new LottoMachine(manualLottos, purchaseCount);
        resultView.outputPurchasedLottos(purchaseCount, lottoMachine);
    }

    private void processWinning() {
        List<String> winNumbers = inputView.inputWinNumbers();
        LottoNumber bonusNumber = new LottoNumber(inputView.inputBonusNumber(winNumbers));

        WinningLotto winningLotto = new WinningLotto(winNumbers, bonusNumber);
        Map<PrizeEnum, Integer> userWinLottos = winningLotto.checkWinLottos(lottoMachine.getLottos());
        LottoProfit lottoProfit = new LottoProfit(userWinLottos);

        resultView.outputLottoResult(userWinLottos, lottoProfit.getProfitRatio(purchaseAmount));
    }
}
