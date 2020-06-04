package lotto;

import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {

        InputView input = new InputView();
        Lotto lotto = new Lotto();
        ResultView resultView = new ResultView();

        int paymentPrice = input.displayIntroInputUI();
        List<String[]> lottoNumbers = lotto.getLottoNumbers(paymentPrice);
        resultView.displayLottoNumbers(lottoNumbers);
        resultView.displayResult(
                lotto.getLottoResult(lottoNumbers, input.displayLastLottoNumberInputUI())
                , paymentPrice);
    }

}
