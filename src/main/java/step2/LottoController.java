package step2;

import step2.domain.LottoService;
import step2.domain.LottoTicket;
import step2.domain.Winner;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        int purchaseAmount = inputView.getPurchaseAmount();

        LottoService lottoService = new LottoService();
        List<LottoTicket> lottoTickets = lottoService.buyTickets(purchaseAmount);

        ResultView resultView = new ResultView();
        resultView.printLottoTickets(lottoTickets);

        String lastWeekWinningInput = inputView.getLastWeekWinningNumbers();
        Winner winner = lottoService.getWiner(lastWeekWinningInput);

        resultView.printWinnerStatistics(winner);

    }
}
