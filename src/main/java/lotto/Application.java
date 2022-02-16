package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoAutoGenerator;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new LottoAutoGenerator());
        lottoController.run();
    }
}
