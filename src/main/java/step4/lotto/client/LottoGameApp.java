package step4.lotto.client;

import step4.lotto.controller.LottoController;

public class LottoGameApp {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.gameStart();
    }
}
