package lotto;

import lotto.domain.LottoMaker;
import lotto.view.input.ConsoleInputView;
import lotto.view.output.OutputView;

public class LottoController {

    public static void main(String[] args) {
        LottoMaker lottoMaker = new LottoMaker(new ConsoleInputView(), new OutputView());
        lottoMaker.run();
    }
}
