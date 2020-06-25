package lotto;

import view.UiManager;

import java.util.*;

public class LottoController {
    private UiManager uiManager = new UiManager();
    private Set<Integer> winningNumbers = new TreeSet<>();
    private TicketCollection tickets;

    public LottoController() {
        tickets = new TicketCollection(uiManager.takeCount());
    }

    public void buyLotto() {
        uiManager.printLottoPurchase(tickets.getCount(), tickets.getTickets());
        winningNumbers = uiManager.takeWinningNumber();
        List<Integer> winningMatcher = Arrays.asList(0, 0, 0, 0, 0, 0, 0);
        int sumPrize = tickets.calculateStatics(winningNumbers, winningMatcher);
        uiManager.printWinningStatistics(winningMatcher, sumPrize);
    }
}
