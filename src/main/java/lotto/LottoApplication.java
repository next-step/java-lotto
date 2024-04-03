package lotto;

import lotto.controller.LottoGame;
import lotto.domain.publish.LottoCalculator;
import lotto.domain.publish.LottoGenerator;
import lotto.domain.publish.RandomLottoNumbersPicker;
import lotto.domain.reward.LottoJudge;
import lotto.service.LottoMachine;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;
import lotto.view.io.Input;
import lotto.view.io.Output;
import lotto.view.io.console.ConsoleInput;
import lotto.view.io.console.ConsoleOutput;

public class LottoApplication {

    public static void main(final String[] args) {
        lottoGame().run();
    }

    private static LottoGame lottoGame() {
        final Input input = new ConsoleInput();
        final Output output = new ConsoleOutput();
        final LottoInputView inputView = new LottoInputView(input, output);
        final LottoOutputView outputView = new LottoOutputView(output);

        final LottoMachine lottoMachine = new LottoMachine(
                new LottoCalculator(),
                new LottoGenerator(new RandomLottoNumbersPicker()),
                new LottoJudge()
        );

        return new LottoGame(inputView, outputView, lottoMachine);
    }
}
