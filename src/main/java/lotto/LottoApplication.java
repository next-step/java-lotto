package lotto;

import lotto.controller.LottoGenerator;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleResultView;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator(new ConsoleInputView(), new ConsoleResultView());
        lottoGenerator.run();
    }
}
