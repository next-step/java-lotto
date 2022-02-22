package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoAutoGenerator;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoAutoGenerator());
        lottoController.run();
    }
}
