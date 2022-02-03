package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;

public class Application {

    public static void main(String[] args) {
        new LottoController(InputView.getAmount())
            .run();
    }
}
