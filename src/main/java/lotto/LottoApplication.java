package lotto;

import lotto.controller.LottosBundleGenerator;
import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        try {
            String purchaseAmount = InputView.getPurchaseAmount();
            String manualLottoCount = InputView.getManualNumberCount();

            LottoPrice price = new LottoPrice(purchaseAmount);
            LottoCount manualCount = new LottoCount(manualLottoCount);

            InputView.printStartManualNumbersInput();
            List<String> manualLottos = InputView.getManualLottosNumbers(new LottoCount(manualLottoCount));

            LottosBundleGenerator lottosBundleGenerator = new LottosBundleGenerator(price, manualCount, manualLottos);
            Lotto lotto = lottosBundleGenerator.generate();

            ResultView.printLotto(manualCount, manualCount.diffFromPrice(price), lotto);

            String winningNumbers = InputView.getWinningNumber();
            String bonusNumber = InputView.getBonusNumber();

            WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
            LottoResult result = lotto.getMatchResult(winningLotto);

            ResultView.printLottoResult(result.toString());
            ResultView.printProfit(result.getProfit());
        } catch (Exception ex) {
            ResultView.printError(ex.getMessage());
        }
    }
}
