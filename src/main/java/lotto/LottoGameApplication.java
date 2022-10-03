package lotto;

import lotto.controller.LottoGameController;
import lotto.view.InputView;

public class LottoGameApplication {
    public static void main(String[] args) {
        new LottoGameController(new InputView()).run();
    }
}
