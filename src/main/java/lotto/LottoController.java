package lotto;

import view.UiManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {
    private UiManager uiManager = new UiManager();
    private List<Integer> winningNumbers = new ArrayList<>();
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
