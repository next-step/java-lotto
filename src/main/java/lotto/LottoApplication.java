package lotto;

import lotto.controller.LottoGame;
import lotto.domain.publish.LottoGenerator;
import lotto.domain.publish.LottoNumbersPicker;
import lotto.domain.publish.RandomLottoNumbersPicker;
import lotto.domain.reward.LottoCalculator;
import lotto.domain.reward.LottoJudge;
import lotto.service.LottoMachine;
import lotto.view.LottoView;
import lotto.view.io.Input;
import lotto.view.io.Output;
import lotto.view.io.console.ConsoleInput;
import lotto.view.io.console.ConsoleOutput;

public class LottoApplication {

    public static void main(final String[] args) {
        new LottoGame(lottoView(), lottoMachine()).run();
    }

    private static LottoView lottoView() {
        final Input input = new ConsoleInput();
        final Output output = new ConsoleOutput();

        return new LottoView(input, output);
    }

    private static LottoMachine lottoMachine() {
        final LottoCalculator lottoCalculator = new LottoCalculator();
        final LottoNumbersPicker lottoNumbersPicker = new RandomLottoNumbersPicker();
        final LottoGenerator lottoGenerator = new LottoGenerator(lottoNumbersPicker);
        final LottoJudge lottoJudge = new LottoJudge();

        return new LottoMachine(lottoCalculator, lottoGenerator, lottoJudge);
    }
}
