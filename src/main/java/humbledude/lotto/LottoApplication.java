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
        List<LottoNumbers> manualLottos = InputView.getNumberOfManualLottos(amountOfManualLotto);
        accountManager.buyManualLottos(manualLottos);

        long amountOfAutoLotto = accountManager.getMaxAmountOfLottos() - amountOfManualLotto;
        ResultView.printAmountPerKind(amountOfAutoLotto, amountOfManualLotto);
        accountManager.buyAutoLottosWithRemainingBudget();
        ResultView.printLottoNumber(accountManager.getMyLottos());

        LottoWinningNumbers winningNumbers = InputView.getWinningNumbers();
        accountManager.setWinningNumbers(winningNumbers);

        ResultView.printStatistics(accountManager);
    }
}
