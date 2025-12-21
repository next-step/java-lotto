package lotto;

import lotto.controller.LottoCountController;
import lotto.controller.LottoMachine;
import lotto.controller.ManualLottoMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        String purchaseAmount = InputView.getPurchaseAmount();
        String manualLottoCount = InputView.getManualNumberCount();

        LottoCountController lottoCountController = new LottoCountController(purchaseAmount, manualLottoCount);
        LottoCount manualCount = lottoCountController.getManualCount();
        LottoCount autoCount = lottoCountController.getAutoCount();

        LottoMachine lottoMachine = new LottoMachine(autoCount);
        ManualLottoMachine manualLottoMachine = new ManualLottoMachine(manualCount);

        InputView.printStartManualNumbersInput();
        while (!manualLottoMachine.isManualNumberInputEnd()) {
            String manualLottoNumbers = InputView.getManualNumbers();
            manualLottoMachine.getManualLottoNumbers(manualLottoNumbers);
        }

        Lotto autoLotto = lottoMachine.generate();
        Lotto manualLotto = manualLottoMachine.generate();

        Lotto lotto = new Lotto(manualLotto, autoLotto);
        ResultView.printLotto(manualCount, autoCount, lotto);

        String winningNumbers = InputView.getWinningNumber();
        String bonusNumber = InputView.getBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoResult result = lotto.getMatchResult(winningLotto);

        ResultView.printLottoResult(result.toString());
        ResultView.printProfit(result.getProfit());
    }
}
