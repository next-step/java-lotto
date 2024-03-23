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

    public void run() {
        Long purchaseAmount = Long.valueOf(inputView.inputPurchase());
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount, new RandomLottoGeneratorStrategy());
        resultView.outputPurchasedLottos(lottoMachine);

        String winNumbers = inputView.inputWinNumbers();
        LottoWinChecker lottoWinChecker = new LottoWinChecker(winNumbers, lottoMachine.getLottos());
        LottoProfitChecker lottoProfitChecker = new LottoProfitChecker(lottoWinChecker.getWinLottos());
        resultView.outputLottoResult(lottoWinChecker.getWinLottos(), lottoProfitChecker.getProfitRatio(purchaseAmount));
    }
}
