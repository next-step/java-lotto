package lotto;

import lotto.controller.LottoGame;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.service.LottoService;
import lotto.strategy.RandomNumberGenerateStrategy;
import lotto.ui.input.ConsoleInputView;
import lotto.ui.input.InputView;
import lotto.ui.output.ConsoleOutputView;
import lotto.ui.output.OutputView;

public class Main {

    public static void main(String[] args) {
        InputView input = new ConsoleInputView();
        LottoService service = new LottoService(RandomNumberGenerateStrategy.newInstance());
        OutputView output = new ConsoleOutputView();

        LottoGame lottoGame = new LottoGame(service, input, output);

        lottoGame.play();
    }
}
