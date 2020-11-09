package lotto;

import lotto.view.ConsoleView;
import lotto.view.View;
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
        return new LottoGame(view(), lottoFactory(), winningChecker());
    }

    private static View view() {
        return new ConsoleView(inputView(), resultView());
    }

    private static InputView inputView() {
        return new ConsoleInputView();
    }

    private static ResultView resultView() {
        return new ConsoleResultView();
    }

    private static LottoFactory lottoFactory() {
        return new LottoFactory();
    }

    private static WinningChecker winningChecker() {
        return new WinningChecker();
    }
}
