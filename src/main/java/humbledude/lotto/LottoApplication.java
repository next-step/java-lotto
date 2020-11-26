package humbledude.lotto;

import humbledude.lotto.domain.*;
import humbledude.lotto.view.InputView;
import humbledude.lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

    private static final AccountManager accountManager = new AccountManager();

    public static void main(String[] args) {
        Budget budget = InputView.getBudget();
        long amountOfManualLotto = InputView.getAmountOfManualLotto();
        budget.setAmountOfManualLottos(amountOfManualLotto);

        List<LottoNumbers> manualLottos = InputView.getNumberOfManualLottos(amountOfManualLotto);
        accountManager.addTickets(manualLottos);

        ResultView.printAmountPerKind(budget);
        buyAutoTicketAndPrintNumbers(budget);

        LottoWinningNumbers winningNumbers = InputView.getWinningNumbers();
        accountManager.setWinningNumbers(winningNumbers);

        ResultView.printStatistics(accountManager);
    }

    private static void buyAutoTicketAndPrintNumbers(Budget budget) {
        List<LottoNumbers> tickets = LottoStore.buyAutoTickets(budget);
        accountManager.addTickets(tickets);
        ResultView.printLottoNumber(accountManager.getTickets());
    }
}
