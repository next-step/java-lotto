package lotto.view;

import lotto.io.ConsoleMessageReader;
import lotto.io.ConsoleMessageWriter;

public class ConsoleViewFactory {

    private ConsoleViewFactory() {
    }

    public static LottoInputView createLottoInputView() {
        return new LottoInputView(
            new ConsoleMessageReader(System.in),
            new ConsoleMessageWriter()
        );
    }
}
