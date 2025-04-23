package lotto;

import lotto.service.LottoGame;
import lotto.view.input.ConsoleInputView;
import lotto.view.output.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoMachine = new LottoGame(new ConsoleInputView(), new ConsoleOutputView());
        lottoMachine.play();
    }
}
