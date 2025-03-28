package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResultsService;
import lotto.domain.RandomNumberGeneration;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGeneration());
        LottoResultsService lottoResultsService = new LottoResultsService();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        LottoController controller = new LottoController(lottoMachine, lottoResultsService, inputView, resultView);
        controller.run();
    }
}
