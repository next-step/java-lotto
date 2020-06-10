package lotto;

import view.UiManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {
    private UiManager uiManager = new UiManager();
    private List<Integer> winningNumbers = new ArrayList<>();
    private List<Integer> winningMatcher = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0, 0));
    private int sumPrize = 0;
    private TicketCollection tickets;

    public LottoController() {
        tickets = new TicketCollection(uiManager.takeCount());
    }

    public void buyLotto() {
        tickets.printLottoPurchase();
        calculateWinningStatistics();
        uiManager.printWinningStatistics(winningMatcher, sumPrize);
    }

    public void calculateWinningStatistics() {
        winningNumbers = uiManager.takeWinningNumber();
        sumPrize = tickets.calculateStatics(winningNumbers, winningMatcher);
    }
}
