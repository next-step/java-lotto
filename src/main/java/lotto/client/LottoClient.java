package lotto.client;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoClient {

    private LottoClient() {
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        LottoController lottoController = new LottoController(inputView, resultView);
        lottoController.startLotto();

    }
}
