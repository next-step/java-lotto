package Lotto;

import Lotto.controller.LottoController;
import Lotto.model.Lotto;
import Lotto.model.LottoService;
import Lotto.model.NumberExtractor.NumberExtractor;
import Lotto.model.NumberExtractor.RandomNumberExtractor;
import Lotto.view.InputView;
import Lotto.view.ResultView;

public class Main {
    public static void main(String[] args){
        final int EXTRACTOR_MIN_VALUE = 1;
        final int EXTRACTOR_MAX_VALUE = 45;

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        NumberExtractor extractor = new RandomNumberExtractor(EXTRACTOR_MIN_VALUE, EXTRACTOR_MAX_VALUE);

        LottoController controller = new LottoController(inputView, resultView, extractor);
        controller.start();
    }
}
