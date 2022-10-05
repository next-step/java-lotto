package calculator.controller;

import calculator.domain.StringCalculator;
import calculator.view.Input;
import calculator.view.Output;

public class StringCalculatorController {

    public void calculator() {
        int calculationResult = new StringCalculator().calculate(new Input().expression());
        new Output().print(calculationResult);
    }
}
