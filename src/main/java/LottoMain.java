import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Statistics;
import lotto.domain.WinnerLotto;
import lotto.model.request.ReqAutoLotto;
import lotto.model.request.ReqManualLotto;
import lotto.service.LottoMachine;
import lotto.service.gernerator.AutoLottoNumbersGenerator;
import lotto.service.gernerator.ManualLottoNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        Money money = InputView.inputPrice();

        Lotto lotto = LottoMachine.issueLotto(new AutoLottoNumbersGenerator(), new ReqAutoLotto(money));
        OutputView.printLottoQuantity(lotto);
        OutputView.printLottoList(lotto);

        List<String> winnerLottoNumber = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber(winnerLottoNumber);
        WinnerLotto winnerLotto = LottoMachine.issueWinnerLotto(new ManualLottoNumbersGenerator(), new ReqManualLotto(winnerLottoNumber), bonusNumber);

        Statistics statistics = new Statistics(winnerLotto, lotto);

        OutputView.printStatisticsResult(statistics);
        OutputView.printProfit(statistics, money);
    }
}
