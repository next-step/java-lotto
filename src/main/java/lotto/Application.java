package lotto;

import lotto.controller.LottoMachine;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(new ConsoleInputView(), new ConsoleOutputView());
        lottoMachine.run();
    }
}
