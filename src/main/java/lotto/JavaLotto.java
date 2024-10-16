package lotto;

import lotto.domain.LottoShuffleGenerator;
import lotto.domain.Lottos;
import lotto.service.WinningStatistic;
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

        WinningStatistic winningStatistic = new WinningStatistic(prize, new Stack<>());
        winningStatistic.calculateStatistic();

        resultView.printResult(winningStatistic.getStatistic());
        resultView.printProfit(winningStatistic.calculateProfit(prize, amount));

    }

}
