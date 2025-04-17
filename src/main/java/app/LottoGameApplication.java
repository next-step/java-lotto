package app;

import controller.LottoController;

public class LottoGameApplication {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.run();
    }
}
