package step3.domain;

import step3.view.InputView;
import step3.view.ResultView;

public class LottoManager {

    LottoTicketSelector lottoTicketSelector;
    WinningTicketSelector winningTicketSelector;

    LottoManager(){
        purchaseLottoTickets();
        drawWinningTickets();
        announceLottoResult();
    }

    private void purchaseLottoTickets(){
        lottoTicketSelector = new LottoTicketSelector(InputView.askPurchaseAmount());
        int ticketCount = lottoTicketSelector.calculateAvailableTicketCount();

        lottoTicketSelector.buyAvailableLottoTickets(ticketCount);
        ResultView.showLottoTickets(lottoTicketSelector.getLottoTickets());
    }

    private void drawWinningTickets(){
        winningTicketSelector = new WinningTicketSelector(InputView.askWinningNumbers(), InputView.askBonusNumber());
        winningTicketSelector.findWinningTicket(lottoTicketSelector.getLottoTickets());
    }

    private void announceLottoResult(){
        ResultView.startStatistics();
        ResultView.showWinningResult(winningTicketSelector.getWinningTypes());

        ProfitCalculator profitCalculator = new ProfitCalculator();
        ResultView.showProfit(profitCalculator.calculateProfitRatio(winningTicketSelector.getWinningTypes(), lottoTicketSelector.getAmount()));
    }

}
