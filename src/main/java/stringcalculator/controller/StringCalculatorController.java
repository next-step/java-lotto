package stringcalculator.controller;

import stringcalculator.model.Input;
import stringcalculator.model.Result;
import stringcalculator.view.InputView;
import stringcalculator.view.ResultView;

public class StringCalculatorController {
    public static void run() {
        Input input = new Input(InputView.input());

        Result result = input.convertToMemories()
                .allCalculate();

        ResultView.print(result);
    }
}
