package lotto;

import lotto.domain.Number;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController() {
        inputView = InputView.getInstance();
        resultView = ResultView.getInstance();
    }

    public void run() {
        int cash = inputView.inputPurchaseAmount();
        Lottos lottos = LottoGenerator.createAutoLottos(new PurchaseAmount(cash));
        resultView.printLottos(lottos.findAll());

        List<Number> winnerNumbers = inputView.inputWinnerNumbers();
        Map<Winner, Integer> winningInfo = lottos.findWinners(winnerNumbers);
        resultView.printWinners(winningInfo);
        resultView.printProfitRate(lottos.findAll().size(), winningInfo);
    }

}
