package lotto;

import lotto.controller.LottoController;

public class LottoMachine {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.run();
    }
}
