package lotto;

import lotto.domain.LottoNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoRunner {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        int payToSum = this.inputView.insertPayToSum();
        this.resultView.printNumberOfPurchasedLotto(payToSum);
        this.pickLotto(payToSum);
    }

    private void pickLotto(int amount){
        for (int i = 0; i < amount; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers();
            List<Integer> pickedLottoNumbers = lottoNumbers.pickLottoNumber();
            this.resultView.printLottoNumbers(pickedLottoNumbers);
        }
    }
}
