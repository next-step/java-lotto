package lotto;

import lotto.lotto.Lottos;
import lotto.lotto.lottonumber.LottoNumber;
import lotto.lotto.lottonumber.LottoNumbers;
import lotto.result.LottoResults;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.getPurchaseAmount();

        Lottos lottos = Lottos.from(purchaseAmount);
        ResultView.printLottoNumbers(lottos);

        InputView.printWinningNumbersRequest();
        LottoNumbers winningNumbers = InputView.getWinningNumbers();
        LottoNumber bonusBall = InputView.getBonusBall();

        LottoResults result = lottos.result(winningNumbers, purchaseAmount);
        ResultView.printResult(result);
    }
}
