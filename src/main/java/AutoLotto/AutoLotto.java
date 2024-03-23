package autoLotto;

import autoLotto.model.LottoMachine;
import autoLotto.model.LottoProfitChecker;
import autoLotto.model.LottoWinChecker;
import autoLotto.model.RandomLottoGeneratorStrategy;
import autoLotto.view.InputView;
import autoLotto.view.ResultView;

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
        String winNumbers = inputView.inputWinNumbers();
        int bonusNumber = inputView.inputBonusNumber();

        LottoWinChecker lottoWinChecker = new LottoWinChecker(winNumbers, lottoMachine.getLottos(), bonusNumber);
        LottoProfitChecker lottoProfitChecker = new LottoProfitChecker(lottoWinChecker.getWinLottos());
        resultView.outputLottoResult(lottoWinChecker.getWinLottos(), lottoProfitChecker.getProfitRatio(purchaseAmount));
    }
}
