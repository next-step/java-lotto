package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;

public class LottoMain {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.buy();
    }
}
