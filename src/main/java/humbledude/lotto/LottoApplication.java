package humbledude.lotto;

import humbledude.lotto.domain.*;
import humbledude.lotto.view.InputView;
import humbledude.lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

    private static final LottoStore store = new LottoStore();
    private static final AccountManager accountManager = new AccountManager();

    public static void main(String[] args) {
        long budget = getBudgetFromUserInput();

        printNumberOfPurchased(budget);

        buyAutoTicketAndPrintNumbers(budget);

        getWinningNumbersFromUserInput();

        claimPrizeAndPrintStatistics();
    }

    private static long getBudgetFromUserInput() {
        return InputView.getBudget();
    }

    private static void printNumberOfPurchased(long budget) {
        long howMany = store.howManyCanIBuy(budget);
        ResultView.printNumberOfPurchased(howMany);
    }

    private static void buyAutoTicketAndPrintNumbers(long budget) {
        List<LottoTicket> tickets = store.buyAutoTickets(budget);
        accountManager.addTickets(tickets);
        ResultView.printLottoNumber(accountManager.getTickets());
    }

    private static void getWinningNumbersFromUserInput() {
        LottoWinningNumbers winningNumbers = InputView.getWinningNumbers();
        store.setWinningNumbers(winningNumbers);
    }

    private static void claimPrizeAndPrintStatistics() {
        accountManager.claimPrize(store);
        ResultView.printStatistics(accountManager);
    }
}
