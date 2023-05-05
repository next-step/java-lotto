package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.WinnerNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        List<LottoNumbers> lottoNumbers = ResultView.printLottoNumbers(purchaseAmount);
        WinnerNumbers winnerNumbers = InputView.inputWinnerNumbers();
        ResultView.printLottoResult(lottoNumbers, winnerNumbers);
    }
}
