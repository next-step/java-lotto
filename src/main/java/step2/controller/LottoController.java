package step2.controller;

import step2.serivce.LottoService;
import step2.domain.LottoTickets;
import step2.domain.Winner;
import step2.view.InputView;
import step2.view.ResultView;

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
