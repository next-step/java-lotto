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

    public void run() {
        Lottos lottos = buyLotto();
        double raffleCash = raffle(lottos);

        resultView.printTotalRevenue(lottos.findAll().size(), raffleCash);
    }

    private Lottos buyLotto() {
        int cash = inputView.inputPurchaseAmount();
        PurchaseAmount purchaseAmount = new PurchaseAmount(cash);

        Lottos lottos = new Lottos();
        lottos.create(purchaseAmount);
        resultView.printLottos(lottos.findAll());
        return lottos;
    }

    private double raffle(Lottos lottos) {
        List<Number> winnerNumbers = inputView.inputWinnerNumbers();
        Map<Winner, Integer> map = lottos.findWinners(winnerNumbers);
        return map.keySet().stream()
                .mapToDouble(winner -> winner.getCash() * map.get(winner))
                .sum();
    }
}
