package lotto;

import lotto.service.LottoService;
import lotto.view.ConsoleView;
import lotto.view.inputview.ConsoleInputView;
import lotto.view.inputview.InputView;
import lotto.view.resultview.ConsoleResultView;
import lotto.view.resultview.ResultView;

public class Main {
    public static void main(String[] args) {
        LottoGame lottoGame = lottoGame();
        lottoGame.start();
    }

    private static LottoGame lottoGame() {
        return new LottoGame(new ConsoleView(inputView(), resultView()), new LottoService());
    }

    private static InputView inputView() {
        return new ConsoleInputView();
    }

    private static ResultView resultView() {
        return new ConsoleResultView();
    }

}
