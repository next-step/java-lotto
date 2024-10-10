package stringcalculator.controller;

import stringcalculator.model.Calculator;
import stringcalculator.model.Input;
import stringcalculator.model.Result;
import stringcalculator.view.InputView;
import stringcalculator.view.ResultView;

public class StringCalculatorController {
    public static void run() {
        Input input = new Input(InputView.input());

        Result result = Calculator.of(input).calculate();

        ResultView.print(result);
    }
}
