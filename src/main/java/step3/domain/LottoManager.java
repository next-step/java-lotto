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

        int manualTicketCount = InputView.askManualTicketCount();
        InputView.askManualTicketNumbers();
        for(int i = 0; i < manualTicketCount; i++){
            lottoTicketSelector.buySingleManualLottoTicket(InputView.inputManualTicketNumbers());
        }

        int totalTicketCount = lottoTicketSelector.calculateAvailableTicketCount();

        lottoTicketSelector.buyAvailableAutoLottoTickets(totalTicketCount);
        ResultView.showLottoTickets(manualTicketCount, lottoTicketSelector.getLottoTickets());
    }

    private void drawWinningTickets(){
        winningTicketSelector = new WinningTicketSelector(InputView.askWinningNumbers(), InputView.askBonusNumber());
        winningTicketSelector.findWinningTicket(lottoTicketSelector.getLottoTickets());
    }

    private void announceLottoResult(){
        ResultView.startStatistics();
        ResultView.showWinningResult(winningTicketSelector.getWinningTypes());

        ResultView.showProfit(ProfitCalculator.calculateProfitRatio(winningTicketSelector.getWinningTypes(), lottoTicketSelector.getAmount()));
    }

}
