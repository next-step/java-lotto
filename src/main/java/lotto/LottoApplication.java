package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoService lottoService = new LottoService();
        LottoController lottoController = new LottoController(inputView, resultView, lottoService);
        lottoController.run();
    }
}
