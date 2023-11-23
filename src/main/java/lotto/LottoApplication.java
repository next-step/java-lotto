package lotto;

import lotto.controller.LottoGenerator;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleResultView;

public class LottoApplication {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator(new ConsoleInputView(), new ConsoleResultView());
        lottoGenerator.run();
    }
}
