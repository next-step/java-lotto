package lotto;

import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.PurchaseAmount;
import lotto.domain.Winner;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView = InputView.getInstance();
    private final ResultView resultView = ResultView.getInstance();
    private static final int PURCHASE_AMOUNT_UNIT = 1000;

    public void run() {
        Lottos lottos = buyLotto();
        Map<Winner, Integer> winningInfo = raffle(lottos);
        double raffleCash = caculateWinningCash(winningInfo);

        resultView.printWinners(winningInfo);
        resultView.printProfitRate(lottos.findAll().size() * PURCHASE_AMOUNT_UNIT, raffleCash);
    }

    private Lottos buyLotto() {
        int cash = inputView.inputPurchaseAmount();
        PurchaseAmount purchaseAmount = new PurchaseAmount(cash);

        Lottos lottos = new Lottos();
        lottos.create(purchaseAmount);
        resultView.printLottos(lottos.findAll());
        return lottos;
    }

    private double caculateWinningCash(Map<Winner, Integer> map) {
        return map.keySet().stream()
                .mapToDouble(winner -> winner.getCash() * map.get(winner))
                .sum();
    }

    private Map<Winner, Integer> raffle(Lottos lottos) {
        List<Number> winnerNumbers = inputView.inputWinnerNumbers();
        return lottos.findWinners(winnerNumbers);
    }
}
