package step2;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private List<LottoTicket> tickets;
    private Map<Integer, List<LottoTicket>> winningTicketsMap = new LinkedHashMap<>();


    public LottoManager() {
        winningTicketsMap.put(5000, new ArrayList<>());
        winningTicketsMap.put(50000, new ArrayList<>());
        winningTicketsMap.put(1500000, new ArrayList<>());
        winningTicketsMap.put(30000000, new ArrayList<>());
        winningTicketsMap.put(2000000000, new ArrayList<>());
    }

    public void start() {
        buyLotto();
        getLottoResult();
        calculateLottoResult();
    }

    public void buyLotto() {
        LottoMaker lottoMaker = new LottoMaker();
        int ticketCount = lottoMaker.getLottoTicketCount(inputView.askAmount());
        tickets = lottoMaker.buyLottoTickets(ticketCount);
        resultView.showLottoTickets(tickets);
    }


    public void getLottoResult() {
        WinningTicketSelector winningTicketSelector = new WinningTicketSelector(inputView.askWinNumbers(), inputView.askBonus());
        resultView.startStatistics();
        resultView.showStatistics(winningTicketSelector.countWinningTicket(winningTicketsMap, winningTicketSelector.findWinningTicket(tickets)));

    }

    public void calculateLottoResult() {
        PrizeCalculator prizeCalculator = new PrizeCalculator();
        resultView.showProfit(prizeCalculator.calculateProfitRatio(tickets, inputView.getAmount()));
    }
}
