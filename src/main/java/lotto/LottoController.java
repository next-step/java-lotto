package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController() {
        inputView = InputView.getInstance();
        resultView = ResultView.getInstance();
    }

    public Lottos createAutoLotto(int cash) {
        Lottos lottos = new Lottos();
        try {
            lottos.create(new PurchaseAmount(cash));
        } catch (IllegalArgumentException e) {
            int possiblePurchaseCount = PurchaseAmount.possiblePurchaseCount(cash);
            resultView.printReInputMessage(possiblePurchaseCount);
            lottos.create(new PurchaseAmount(possiblePurchaseCount));
        }
        return lottos;
    }

    public List<Lotto> findLottos(Lottos lottos) {
        return lottos.findAll();
    }

    public int findLottoSize(Lottos lottos) {
        return lottos.findAll().size();
    }

}
