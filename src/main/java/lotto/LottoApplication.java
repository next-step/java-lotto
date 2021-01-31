package lotto;

import lotto.controller.Controller;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        Controller controller = new Controller(
            new InputView(),
            new OutputView()
        );

        controller.playGame(
            controller.buyTickets(),
            controller.generateAnswer()
        );
    }
}
