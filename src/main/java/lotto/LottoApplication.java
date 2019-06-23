package lotto;

import lotto.common.ConsoleInputer;
import lotto.common.ConsoleOuter;
import lotto.common.Outer;
import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        Outer outer = new ConsoleOuter();
        InputView inputView = new InputView(new ConsoleInputer(), outer);
        ResultView consoleResultView = new ResultView(outer);
        LottoController controller = new LottoController(inputView, consoleResultView);
        
        controller.runBuyingLottoProcess();
        controller.runResultProcess();
    }
}
