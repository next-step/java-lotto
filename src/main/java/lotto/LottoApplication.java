package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoResultCalculator;
import lotto.domain.strategy.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new InputView(),
                new OutputView(),
                new LottoResultCalculator(
                        List.of(
                                new ThreeMatchStrategy(),
                                new FourMatchStrategy(),
                                new FiveMatchStrategy(),
                                new FiveAndBonusMatchStrategy(),
                                new SixMatchStrategy()
                        )
                )

        );
        lottoController.startGame();
    }
}
