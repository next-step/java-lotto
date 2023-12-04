package lotto;


import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {

    public static void main(String[] args) {
        new LottoController(new InputView(), new OutputView()).game();
    }

}
