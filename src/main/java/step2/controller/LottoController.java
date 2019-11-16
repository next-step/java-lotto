package step2.controller;

import step2.domain.LottoNum;
import step2.domain.LottoTickets;
import step2.domain.Winner;
import step2.serivce.LottoService;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoController {

    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        LottoTickets lottoTickets = LottoService.buyTickets(purchaseAmount);
        ResultView.printLottoTickets(lottoTickets);

        String lastWeekWinningInput = InputView.getLastWeekWinningNumbers();

        LottoNum bonus = new LottoNum(InputView.getBonus(), lastWeekWinningInput);

        Winner winner = LottoService.match(lottoTickets, lastWeekWinningInput, bonus);
        ResultView.printWinnerStatistics(winner);

    }
}
