package lotto;

import lotto.view.input.CommandLineReader;
import lotto.view.input.DefaultInputView;
import lotto.view.result.DefaultResultView;

public class Main {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new DefaultInputView(new CommandLineReader()),
                new DefaultResultView());

        lottoController.run();
    }
}
