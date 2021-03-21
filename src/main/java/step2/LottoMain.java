package step2;

import step2.controller.LottoController;

public class LottoMain {
    public static void main(String[] args) {
        LottoController lottoService = new LottoController();
        lottoService.buyManualLotto();
    }
}
