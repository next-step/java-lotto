package lotto;

import lotto.controller.LottoController;

public class LottoApplication {

    public static void main(String[] args) {
        final LottoController lottoController = new LottoController();
        lottoController.start();
    }
}
