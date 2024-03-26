package lotto.domain;

import common.view.LottoInputView;
import common.view.ResultView;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final LottoTickets lottoTickets;

    public LottoGame(int ticketCount) {
        this.lottoTickets = new LottoTickets(LottoMachine.purchaseLottoTickets(ticketCount));
    }

    public void playGame() {
        ResultView.showTicketNumber(lottoTickets.getTickets());
        List<Integer> winningNumber = LottoInputView.requestWinningNumbers();
        Map<Integer, Integer> winningResult = lottoTickets.winningCheck(winningNumber);
        ResultView.printResult(winningResult, lottoTickets.profitRate(winningResult));
    }
}
