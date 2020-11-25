package step2;

import step2.controller.LottoController;

public class LottoGameApp {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        lottoController.start();
    }
}
