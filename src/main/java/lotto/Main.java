package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView(), new ResultView());
        lottoController.start();
    }

}
