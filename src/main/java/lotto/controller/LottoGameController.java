package lotto.controller;

import lotto.domain.User;
import lotto.view.InputView;

public class LottoGameController {
    private final InputView inputView;

    public LottoGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        User user = inputView.getUserInput();
    }
}
