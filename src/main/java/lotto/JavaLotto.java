package lotto;

import lotto.domain.LottoShuffleGenerator;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Stack;

public class JavaLotto {

    private final InputView inputView;
    private final ResultView resultView;

    JavaLotto(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void playLotto() {

        int amount = inputView.inputPurchaseAmountGuide();

        Lottos lottos = Lottos.createLottos(amount, LottoShuffleGenerator.getLottoShuffleGenerator());

        resultView.NumberOfLotto(lottos.getNumberOfLotto());
        resultView.printPurchasedLottos(lottos);

        int prize = lottos.getWinningPrize(inputView.inputWinnerNumber());

        lottos.calculateStatistic(prize, new Stack<>());

        resultView.printResult(lottos.calculateStatistic(prize, new Stack<>()));
        resultView.printProfit(lottos.calculateProfit(prize, amount));

    }

}
