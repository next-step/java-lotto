package step2.controller;

import step2.domain.Bonus;
import step2.serivce.LottoService;
import step2.domain.LottoTickets;
import step2.domain.Winner;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoController {

    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();

        LottoTickets lottoTickets = LottoService.buyTickets(purchaseAmount);

        ResultView.printLottoTickets(lottoTickets);

        String lastWeekWinningInput = InputView.getLastWeekWinningNumbers();

        Bonus bonus = InputView.getBonus();
        Winner winner = new Winner(lottoTickets, lastWeekWinningInput, bonus);

        ResultView.printWinnerStatistics(winner);

    }
}
