package step2;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private List<LottoTicket> tickets;
    private final Map<Integer, List<LottoTicket>> winningTicketsMap = new LinkedHashMap<>();


    public LottoManager() {
        winningTicketsMap.put(3, new ArrayList<>());
        winningTicketsMap.put(4, new ArrayList<>());
        winningTicketsMap.put(5, new ArrayList<>());
        winningTicketsMap.put(6, new ArrayList<>());
    }

    public void buyLotto() {
        LottoMaker lottoMaker = new LottoMaker();
        inputView.askAmount();
        int ticketCount = lottoMaker.getLottoTicketCount(inputView.getAmount());
        tickets = lottoMaker.buyLottoTickets(ticketCount);
        resultView.showLottoTickets(tickets);
    }

    public void showWinningLotto() {
        inputView.askWinNumbers();
    }

    public void getLottoResult() {
        WinningTicketSelector winningTicketSelector = new WinningTicketSelector(inputView.getWinNumbers());
        resultView.startStatistics();
        winningTicketSelector.findWinningTicket(tickets);
        winningTicketSelector.countWinningTicket(winningTicketsMap, tickets);
        resultView.showStatistics(winningTicketsMap);

    }

    public void calculateLottoResult() {
        PrizeCalculator prizeCalculator = new PrizeCalculator();
        resultView.showProfit(prizeCalculator.calculateProfitRatio(tickets, inputView.getAmount()));
    }

}
