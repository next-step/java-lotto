package lotto.controller;

import lotto.domain.lotto.wrapper.WinningNumber;
import lotto.domain.rankcount.RankCountGroup;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Set;

public class WinningController {

    private final InputView inputView;
    private final ResultView resultView;

    public WinningController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public WinningNumber winning() {
        Set<Integer> winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber(winningNumbers);

        return new WinningNumber(winningNumbers, bonusNumber);
    }

    public void result(RankCountGroup rankCountGroup, double profitRate) {
        resultView.printLottoGameResult(rankCountGroup, profitRate);
    }
}
