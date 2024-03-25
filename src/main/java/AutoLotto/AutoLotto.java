package autoLotto;

import autoLotto.model.*;
import autoLotto.view.InputView;
import autoLotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class AutoLotto {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    private int numberOfTotalLottos;
    private LottoMachine lottoMachine;

    public void run() {
        processPurchase();
        processWinning();
    }

    private void processPurchase() {
        numberOfTotalLottos = Integer.valueOf(inputView.inputPurchase());
        int numberOfManualLottos = inputView.inputManualPurchase(numberOfTotalLottos);
        List<Lotto> manualLottos = inputView.buyManualLottos(numberOfManualLottos);
        int numberOfAutoLottos = numberOfTotalLottos - numberOfManualLottos;

        lottoMachine = new LottoMachine(manualLottos, numberOfTotalLottos);
        resultView.outputPurchasedLottos(numberOfManualLottos, numberOfAutoLottos, lottoMachine);
    }

    private void processWinning() {
        List<String> winNumbers = inputView.inputWinNumbers();
        int bonusNumber = inputView.inputBonusNumber(winNumbers);

        LottoWinChecker lottoWinChecker = new LottoWinChecker(winNumbers, bonusNumber);
        Map<PrizeEnum, Integer> userWinLottos = lottoWinChecker.checkWinLottos(lottoMachine.getLottos());
        LottoProfitChecker lottoProfitChecker = new LottoProfitChecker(userWinLottos);

        resultView.outputLottoResult(userWinLottos, lottoProfitChecker.getProfitRatio(numberOfTotalLottos));
    }
}
