package Lotto;

import Lotto.service.LottoGame;
import Lotto.view.ConsoleInputView;
import Lotto.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoMachine = new LottoGame(new ConsoleInputView(), new ConsoleOutputView());
        lottoMachine.play();
    }
}
