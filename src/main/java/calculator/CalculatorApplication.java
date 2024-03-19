package calculator;

import calculator.controller.Calculator;
import calculator.model.Validator;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorApplication {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(new InputView(), new ResultView(), new Validator());
        calculator.start();
    }
}
