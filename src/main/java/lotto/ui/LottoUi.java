package lotto.ui;

import lotto.controller.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.Statistics;
import lotto.ui.view.InputView;
import lotto.ui.view.OutputView;

public class LottoUi {

    public static void main(String[] args) {
        int won = InputView.getWon();
        LottoTicket lottoTicket = LottoMachine.publish(won);
        OutputView.showTicket(lottoTicket);

        String winningNumbers = InputView.getWinningNumbers();
        Statistics statistics = LottoMachine.rank(lottoTicket, winningNumbers);
        OutputView.showStatistics(statistics);
    }

}
