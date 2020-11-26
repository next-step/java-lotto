package humbledude.lotto;

import humbledude.lotto.domain.*;
import humbledude.lotto.view.InputView;
import humbledude.lotto.view.ResultView;

import java.util.List;

public class LottoApplication {


    public static void main(String[] args) {
        long budget = InputView.getBudget();
        AccountManager accountManager = new AccountManager(budget);

        long amountOfManualLotto = InputView.getAmountOfManualLotto();
        accountManager.setAmountOfManualLottos(amountOfManualLotto);

        List<LottoNumbers> manualLottos = InputView.getNumberOfManualLottos(amountOfManualLotto);
        accountManager.addTickets(manualLottos);

        ResultView.printAmountPerKind(accountManager);
        accountManager.buyAutoTicketsWithRemainingBudget();
        ResultView.printLottoNumber(accountManager.getTickets());

        LottoWinningNumbers winningNumbers = InputView.getWinningNumbers();
        accountManager.setWinningNumbers(winningNumbers);

        ResultView.printStatistics(accountManager);
    }
}
