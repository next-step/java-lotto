package humbledude.lotto;

import humbledude.lotto.domain.*;
import humbledude.lotto.view.InputView;
import humbledude.lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

    private static final AccountManager accountManager = new AccountManager();

    public static void main(String[] args) {
        long budget = InputView.getBudget();

        printNumberOfPurchased(budget);

        buyAutoTicketAndPrintNumbers(budget);

        LottoWinningNumbers winningNumbers = InputView.getWinningNumbers();
        accountManager.setWinningNumbers(winningNumbers);

        ResultView.printStatistics(accountManager);
    }

    private static void printNumberOfPurchased(long budget) {
        long howMany = LottoStore.howManyCanIBuy(budget);
        ResultView.printNumberOfPurchased(howMany);
    }

    private static void buyAutoTicketAndPrintNumbers(long budget) {
        List<LottoNumberSet> tickets = LottoStore.buyAutoTickets(budget);
        accountManager.addTickets(tickets);
        ResultView.printLottoNumber(accountManager.getTickets());
    }
}
