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
        winningTicketsMap.put(3, new ArrayList<>());
        winningTicketsMap.put(4, new ArrayList<>());
        winningTicketsMap.put(5, new ArrayList<>());
        winningTicketsMap.put(6, new ArrayList<>());
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
        WinningTicketSelector winningTicketSelector = new WinningTicketSelector(inputView.askWinNumbers());
        resultView.startStatistics();
        resultView.showStatistics(winningTicketSelector.countWinningTicket(winningTicketsMap, winningTicketSelector.findWinningTicket(tickets)));

    }

    public void calculateLottoResult() {
        PrizeCalculator prizeCalculator = new PrizeCalculator();
        resultView.showProfit(prizeCalculator.calculateProfitRatio(tickets, inputView.getAmount()));
    }
}
