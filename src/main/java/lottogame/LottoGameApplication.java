package lottogame;

import lottogame.controller.LottoGameController;
import lottogame.view.InputView;
import lottogame.view.OutputView;

public class LottoGameApplication {
    public static void main(String[] args) {
        new LottoGameController(new InputView(), new OutputView()).run();
    }
}
