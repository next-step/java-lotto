package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoResultCalculator;
import lotto.domain.strategy.FiveMatchStrategy;
import lotto.domain.strategy.FourMatchStrategy;
import lotto.domain.strategy.SixMatchStrategy;
import lotto.domain.strategy.ThreeMatchStrategy;
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
                                new SixMatchStrategy()
                        )
                )

        );
        lottoController.startGame();
    }
}
