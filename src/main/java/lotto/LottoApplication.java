package lotto;

import lotto.controller.LottoController;

public class LottoApplication {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.startLotto();
    }
}
