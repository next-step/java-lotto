package lotto;

import lotto.controller.LottoGameController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameApplication {
    public static void main(String[] args) {
        new LottoGameController(new InputView(), new OutputView()).run();
    }
}
