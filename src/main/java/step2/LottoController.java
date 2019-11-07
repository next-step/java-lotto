package step2;

import step2.domain.LottoService;
import step2.domain.LottoTicket;
import step2.domain.LottoTickets;
import step2.domain.Winner;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();

        LottoService lottoService = new LottoService();
        LottoTickets lottoTickets = lottoService.buyTickets(purchaseAmount);

        ResultView.printLottoTickets(lottoTickets);

        String lastWeekWinningInput = InputView.getLastWeekWinningNumbers();
        Winner winner = lottoService.getWiner(lottoTickets, lastWeekWinningInput);

        ResultView.printWinnerStatistics(winner);

    }
}
