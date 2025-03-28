package Lotto;

import Lotto.controller.LottoController;
import Lotto.model.LottoService;
import Lotto.model.NumberExtractor.NumberExtractor;
import Lotto.model.NumberExtractor.RandomNumberExtractor;
import Lotto.view.InputView;
import Lotto.view.ResultView;

public class Main {
    public static void main(String[] args){
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        NumberExtractor extractor = new RandomNumberExtractor();

        LottoController controller = new LottoController(inputView, resultView, extractor);
        controller.start();
    }
}
