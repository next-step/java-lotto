package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;

public class LottoApplication {

    public static void main(String[] args) {
        new LottoController(new LottoService()).run();
    }
}
