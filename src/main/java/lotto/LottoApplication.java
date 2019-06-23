package lotto;

import lotto.controller.LottoController;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleResultView;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        InputView consoleInputView = new ConsoleInputView();
        ResultView consoleResultView = new ConsoleResultView();
        LottoController controller = new LottoController(consoleInputView, consoleResultView);
        controller.runBuyingLottoProcess();
        controller.runResultProcess();
    }
}
