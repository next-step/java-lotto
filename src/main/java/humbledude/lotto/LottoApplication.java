package humbledude.lotto;

import humbledude.lotto.domain.*;
import humbledude.lotto.view.InputView;
import humbledude.lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoApplication {

    public static void main(String args[]) {
        LottoStore store = new LottoStore();
        AccountManager accountManager = new AccountManager();

        long budget = InputView.getBudget();
        long howMany = store.howManyCanIBuy(budget);
        ResultView.printNumberOfPurchased(howMany);

        List<LottoTicket> tickets = store.buyAutoTickets(budget);
        accountManager.addSpent(howMany * LottoStore.LOTTO_TICKET_PRICE);
        for (LottoTicket ticket : tickets) {
            ResultView.printLottoNumber(ticket);
        }

        LottoNumbers numbers = LottoNumbers.of(InputView.getWinningNumbers());
        LottoWinningNumbers winningNumbers = new LottoWinningNumbers(numbers);
        store.setWinningNumbers(winningNumbers);

        Map<LottoPrize, List<LottoTicket>> result = store.claimPrizeForMultipleTickets(tickets);
        accountManager.addPrize(result);
        ResultView.printStatistics(result);
        ResultView.printProfitRate(accountManager);
    }
}
