package step1.calculator.controller;

import step1.calculator.view.InputView;
import step1.calculator.view.OutputView;

public class CalculatorApp {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public CalculatorApp() {

    }

    public void run() {
        String input = inputView.getInput();

        int result = -1;

        outputView.print(result);
    }

}
