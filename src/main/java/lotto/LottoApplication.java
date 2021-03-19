package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoPlay;
import lotto.view.InputView;

public class LottoApplication {

    public static void main(String[] args) {
        new LottoController(new InputView(), new LottoPlay()).run();
    }
}
