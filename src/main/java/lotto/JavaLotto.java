package lotto;

import lotto.domain.LottoShuffleGenerator;
import lotto.domain.Lottos;
import lotto.domain.WinningCheck;
import lotto.domain.WinningNumber;
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
        WinningNumber winningNumber = new WinningNumber();
        Lottos lottos = new Lottos();

        int amount = inputView.inputPurchaseAmountGuide();

        lottos.buyLotto(amount, LottoShuffleGenerator.getLottoShuffleGenerator());

        resultView.NumberOfLotto(lottos.getNumberOfLotto());
        resultView.printPurchasedLottos(lottos);

        winningNumber.convertStringToIntList(inputView.inputWinnerNumber());

        WinningCheck winningCheck = new WinningCheck(lottos, winningNumber);
        int prize = winningCheck.getWinningPrize();

        WinningStatistic winningStatistic = new WinningStatistic(prize, new Stack<>());
        winningStatistic.calculateStatistic();

        resultView.printResult(winningStatistic.getStatistic());
        resultView.printProfit(winningStatistic.calculateProfit(prize, amount));

    }

}
