package lotto.controller;

import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {
    public void pull() {
        int userAmount = InputView.inputUserAmount();

        Lottos lottos = new Lottos(userAmount);
        OutputView.outputLottoNumbers(lottos);

        String previousWeekWinningNumber = InputView.inputPreviousWeekWinningNumber();
        OutputView.outputWinningStatistics(lottos, previousWeekWinningNumber);
        OutputView.outputRevenueRate(lottos, previousWeekWinningNumber);
    }
}
