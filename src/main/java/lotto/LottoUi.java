package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

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
