package lotto;

import lotto.controller.LottoController;
import view.InputView;
import view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(InputView.getInstance(), OutputView.getInstance());
        lottoController.play();
    }
}
