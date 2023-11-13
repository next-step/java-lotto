package lotto;

import lotto.controller.LottoController;
import lotto.domain.lotto.strategy.RandomStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        new LottoController(new InputView(), new OutputView(), new RandomStrategy());
    }
}
