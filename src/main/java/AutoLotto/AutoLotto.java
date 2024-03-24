package autoLotto;

import autoLotto.model.*;
import autoLotto.view.InputView;
import autoLotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class AutoLotto {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    private Long purchaseAmount;
    private LottoMachine lottoMachine;

    public void run() {
        processPurchase();
        processWinning();
    }

    private void processPurchase() {
        purchaseAmount = Long.valueOf(inputView.inputPurchase());
        lottoMachine = new LottoMachine(purchaseAmount, new RandomLottoGeneratorStrategy());
        resultView.outputPurchasedLottos(lottoMachine);
    }

    private void processWinning() {
        List<String> winNumbers = inputView.inputWinNumbers();
        int bonusNumber = inputView.inputBonusNumber();

        LottoWinChecker lottoWinChecker = new LottoWinChecker(winNumbers);
        Map<PrizeEnum, Integer> userWinLottos = lottoWinChecker.checkWinLottos(lottoMachine.getLottos(), bonusNumber);
        LottoProfitChecker lottoProfitChecker = new LottoProfitChecker(userWinLottos);

        resultView.outputLottoResult(userWinLottos, lottoProfitChecker.getProfitRatio(purchaseAmount));
    }
}
