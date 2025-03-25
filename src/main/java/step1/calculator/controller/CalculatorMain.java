package step1.calculator.controller;

import step1.calculator.model.Validator;
import step1.calculator.view.InputView;
import step1.calculator.view.OutputView;

public class CalculatorMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        String input = inputView.getInput();

        Validator validator = new Validator();
        validator.validate(input);

        CalculatorApp calculatorApp = new CalculatorApp();
        int result = calculatorApp.calculates(input);

        OutputView outputView = new OutputView();
        outputView.print(result);
    }

}
