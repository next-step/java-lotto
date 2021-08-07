package lotto.step2;

import lotto.step2.view.InputView;
import lotto.step2.view.ResultView;

public class LottoController {
    public static void main(String[] args) {
        int lottoPrice = InputView.inputLottoPrice();
        ResultView.printLottoCount(lottoPrice);
    }
}
