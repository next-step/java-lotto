package lotto.view;

import lotto.domain.LottoWinningResults;
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

    public static LottoResultView createLottoResultView(final LottoWinningResults results) {
        return new LottoResultView(
            new ConsoleMessageWriter(),
            results
        );
    }
}
