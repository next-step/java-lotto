package step2.domain;

import step2.view.InputView;
import step2.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {

    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();
    private LottoTicketMaker lottoTicketMaker;

    public LottoManager(LottoTicketMaker lottoTicketMaker){
        this.lottoTicketMaker = lottoTicketMaker;
    }

    public void startLotto(){
        List<LottoTicket> tickets = new ArrayList<>();

        inputView.askAmount();
        tickets = lottoTicketMaker.buyAvailableLottoTickets(lottoTicketMaker.calculateAvailableCount(inputView.getAmount()));
        resultView.showLottoTickets(tickets);

        drawLotto(tickets);
        calculateLottoResult(tickets);
    }

    private void drawLotto(List<LottoTicket> tickets){
        WinningTicketSelector winningTicketSelector = new WinningTicketSelector(inputView.askWinningNumbers());
        resultView.showStatistics(winningTicketSelector.categorizeWinningTicket(winningTicketSelector.findWinningTicket(tickets)));
    }

    private void calculateLottoResult(List<LottoTicket> tickets){
        PrizeCalculator prizeCalculator = new PrizeCalculator();
        resultView.showProfit(prizeCalculator.calculateProfitRatio(tickets, inputView.getAmount()));
    }

}
