package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoController lottoController = new LottoController(inputView, resultView);
        lottoController.run();
    }
}
