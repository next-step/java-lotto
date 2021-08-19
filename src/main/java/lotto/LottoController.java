package lotto;

import lotto.domain.Lottos;
import lotto.domain.Numbers;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;

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

    public int inputPurchaseAmount() {
        return inputView.inputPurchaseAmount();
    }

    public void printLottos(Lottos lottos) {
        resultView.printLottos(lottos.findAll());
    }

    public Numbers inputWinnerNumbers() {
        return new Numbers(inputView.inputWinnerNumbers());
    }

    public void printRanks(Map<Rank, Integer> rankInfo) {
        resultView.printWinners(rankInfo);
    }

    public void printProfitRate(Lottos lottos, Map<Rank, Integer> rankInfo) {
        int lottoSize = lottos.findAll().size();
        resultView.printProfitRate(lottoSize, rankInfo);
    }

}
