package lotto;

import lotto.domain.LottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        List<LottoNumbers> lottoNumbers = ResultView.printLottoNumbers(purchaseAmount);
        LottoNumbers winnerNumbers = InputView.inputLottoNumbers();
        ResultView.printLottoResult(lottoNumbers, winnerNumbers);
    }
}
