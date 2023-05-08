package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    private static final InputView INPUT_VIEW = new InputView();
    private static final ResultView RESULT_VIEW = new ResultView();

    public static void main(String args[]){
        LottoController lottoController = new LottoController(INPUT_VIEW, RESULT_VIEW);
        lottoController.play();
    }
}
