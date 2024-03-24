package calculator;

import calculator.controller.Calculator;
import calculator.model.Validator;
import calculator.view.CalculatorInputView;
import calculator.view.CalculatorResultView;

public class CalculatorApplication {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(new CalculatorInputView(), new CalculatorResultView(), new Validator());
        calculator.start();
    }
}
