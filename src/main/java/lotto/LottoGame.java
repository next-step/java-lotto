package lotto;

import lotto.view.inputview.InputView;
import lotto.view.resultview.ResultView;

import java.util.List;
import java.util.Set;

public class LottoGame {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoFactory lottoFactory;
    private final WinningChecker winningChecker;

    public LottoGame(InputView inputView, ResultView resultView, LottoFactory lottoFactory, WinningChecker winningChecker) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoFactory = lottoFactory;
        this.winningChecker = winningChecker;
    }

    public void start() {
        int amount = inputView.getAmount();
        List<Lotto> boughtLottos = lottoFactory.buyLottos(amount);
        resultView.printBoughtLottos(boughtLottos);
        Set<Integer> winningNumbers = inputView.getWinningNumbers();
        WinningStatistic winningStatistic = winningChecker.getResult(winningNumbers, boughtLottos);
        resultView.printWinningStatistic(winningStatistic);
    }
}
