package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoGame {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    private PurchaseAmount purchaseAmount;
    private LottoMachine lottoMachine;

    public void run() {
        processPurchase();
        processWinning();
    }

    private void processPurchase() {
        purchaseAmount = inputView.inputPurchase();
        int numberOfManualLottos = inputView.inputManualPurchase(purchaseAmount);
        List<String> manualLottos = inputView.buyManualLottos(numberOfManualLottos);

        lottoMachine = new LottoMachine(manualLottos, purchaseAmount);
        resultView.outputPurchasedLottos(purchaseAmount, manualLottos.size(), lottoMachine);
    }

    private void processWinning() {
        List<String> winNumbers = inputView.inputWinNumbers();
        LottoNumber bonusNumber = new LottoNumber(inputView.inputBonusNumber());

        WinningLotto winningLotto = new WinningLotto(winNumbers, bonusNumber);
        Map<PrizeEnum, Integer> userWinLottos = winningLotto.checkWinLottos(lottoMachine.getLottos());
        LottoProfit lottoProfit = new LottoProfit(userWinLottos);

        resultView.outputLottoResult(userWinLottos, lottoProfit.getProfitRatio(purchaseAmount));
    }
}
