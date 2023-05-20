import lotto.domain.*;
import lotto.model.request.ReqAutoLotto;
import lotto.service.LottoMachine;
import lotto.service.gernerator.AutoLottoNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        Money inputMoney = InputView.inputPrice();

        Money manualPurchaseAmount = InputView.inputManualNumberOfPurchases(inputMoney);
        Money autoPurchaseAmount = inputMoney.minus(manualPurchaseAmount);

        List<LottoNumbers> manualLottoNumbers = InputView.inputManualLottoNumber(manualPurchaseAmount);
        Lotto lotto = LottoMachine.issueLotto(new AutoLottoNumbersGenerator(), new ReqAutoLotto(autoPurchaseAmount), manualLottoNumbers);
        OutputView.printLottoQuantity(manualPurchaseAmount, autoPurchaseAmount);
        OutputView.printLottoList(lotto);

        LottoNumbers winnerLottoNumber = InputView.inputWinningNumbers();
        LottoNumber bonusNumber = InputView.inputBonusNumber(winnerLottoNumber);
        WinnerLotto winnerLotto = new WinnerLotto(winnerLottoNumber, bonusNumber);

        Statistics statistics = new Statistics(winnerLotto, lotto, inputMoney);

        OutputView.printStatisticsResult(statistics);
        OutputView.printProfit(statistics);
    }

}
