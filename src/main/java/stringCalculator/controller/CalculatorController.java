package stringCalculator.controller;

import stringCalculator.view.InputView;
import stringCalculator.utils.Message;
import stringCalculator.view.ResultView;
import stringCalculator.domain.Calculator;

public class CalculatorController {

    public static void run() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Calculator calculator = new Calculator();

        String[] operations = inputView.inputData().split(Message.BLANK.getMessage());
        int result = Integer.parseInt(operations[0]);
        for (int i=1; i<operations.length; i+=2) {
            result = calculator.calculate(operations[i], result, Integer.parseInt(operations[i+1]));
        }

        resultView.showResult(result);
    }
}
