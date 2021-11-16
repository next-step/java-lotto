package controller;

import view.ConsoleInputView;
import view.InputView;

public class LottoGame {

    private LottoGame() {

    }

    public static void run() {
        InputView inputView = new ConsoleInputView();
        inputView.showPurchaseAmountInputMessage();
        int purchaseAmount = inputView.extractPurchaseAmount();

        inputView.showWinningNumberInputMessage();
        String winningNumber = inputView.extractWinningNumber();
    }
}
