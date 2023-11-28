package calculator.controller;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class MainController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String input = inputView.input();

        try {
            Calculator calculator = new Calculator(input);
            outputView.print(calculator.result());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
