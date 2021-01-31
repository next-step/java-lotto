package lotto;

import lotto.controller.LottoController;
import lotto.view.ConsoleOutputView;
import lotto.view.InputView;
import lotto.view.KeyboardInputView;
import lotto.view.OutputView;

public class ApplicationContext {

    private final InputView inputView;
    private final OutputView outputView;

    public ApplicationContext() {
        this.inputView = new KeyboardInputView(System.in);
        this.outputView = new ConsoleOutputView();
    }

    public LottoController getLottoController() {
        return new LottoController(inputView, outputView);
    }
}
