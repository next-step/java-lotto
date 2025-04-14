package Lotto;

import Lotto.service.LottoGame;
import Lotto.view.input.ConsoleInputView;
import Lotto.view.output.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoMachine = new LottoGame(new ConsoleInputView(), new ConsoleOutputView());
        lottoMachine.play();
    }
}
