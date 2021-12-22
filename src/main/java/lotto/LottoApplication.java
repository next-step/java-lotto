package lotto;

import lotto.lotto.Lottos;
import lotto.result.LottoResults;
import lotto.result.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();

        Lottos lottos = Lottos.from(purchaseAmount);
        ResultView.printLottoNumbers(lottos);

        WinningNumbers winningNumbers = InputView.getWinningNumbers();
        LottoResults result = lottos.result(winningNumbers, purchaseAmount);

        ResultView.printResult(result);
    }
}
