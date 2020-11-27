package step3.lotto.client;

import step2.lotto.automatic.controller.LottoController;

public class LottoGameApp {
    private static LottoController lottoController = new LottoController();

    public static void main(String[] args) {
        lottoController.gameStart();
    }
}
