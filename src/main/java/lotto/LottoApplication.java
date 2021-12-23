package lotto;

import lotto.lotto.Lottos;
import lotto.result.LottoResults;
import lotto.result.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();
        Lottos manualLottos = InputView.getManualLottos();

        Lottos lottos = Lottos.of(purchaseAmount, manualLottos);
        ResultView.printLottoNumbers(lottos);

        WinningNumbers winningNumbers = InputView.getWinningNumbers();
        LottoResults result = lottos.result(winningNumbers, purchaseAmount);

        ResultView.printResult(result);
    }
}
