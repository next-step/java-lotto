package lotto;

import lotto.controller.LottoController;

public class LottoMain {
    public static void main(String[] args) {
        LottoController controller = new LottoController();
        controller.playLotto();
        controller.showResult();
    }
}
