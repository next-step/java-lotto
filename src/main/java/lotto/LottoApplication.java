package lotto;

import lotto.controller.LottoController;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleResultView;

public class LottoApplication {
    public static void main(String[] args) {
        LottoController lottoGenerator = new LottoController(new ConsoleInputView(), new ConsoleResultView());
        lottoGenerator.run();
    }
}
