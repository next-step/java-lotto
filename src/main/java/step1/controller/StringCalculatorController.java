package step1.controller;

import step1.view.InputView;

public class StringCalculatorController {

    public static void run() {
        InputView inputView = new InputView();

        inputView.printInputMessage();
        inputView.inputExpression();

    }
}
