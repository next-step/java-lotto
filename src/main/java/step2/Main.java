package step2;

import step2.domain.PrizeCalculator;
import step2.domain.TicketSelector;
import step2.domain.WinningTicketSelector;
import step2.view.InputView;
import step2.view.ResultView;

public class Main {

    public static void main(String[] args) {
        TicketSelector ticketSelector = new TicketSelector();
        PrizeCalculator prizeCalculator = new PrizeCalculator();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.askAmount();
        ticketSelector.buyAvailableLottoTickets(ticketSelector.calculateAvailableCount(inputView.getAmount()));
        resultView.showLottoTickets(ticketSelector.getLottoTickets());

        inputView.askWinningNumbers();

        WinningTicketSelector winningTicketSelector = new WinningTicketSelector(inputView.getWinningNumbers());
        winningTicketSelector.findWinningTicket(ticketSelector.getLottoTickets());
        resultView.startStatistics();
        resultView.showStatistics(winningTicketSelector.getWinningTicketCategoriesByPrize());
        resultView.showProfit(prizeCalculator.calculateProfitRatio(winningTicketSelector.getWinningTicketCategoriesByPrize(), inputView.getAmount()));

    }
}
