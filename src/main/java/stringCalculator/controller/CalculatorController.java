package stringCalculator.controller;

import stringCalculator.view.InputView;
import stringCalculator.utils.Message;
import stringCalculator.view.ResultView;
import stringCalculator.domain.Calculator;

public class CalculatorController {

    private static final InputView INPUT_VIEW = new InputView();
    private static final ResultView RESULT_VIEW = new ResultView();

    public static void run() {
        Calculator calculator = new Calculator();

        String[] operations = INPUT_VIEW.inputData().split(Message.BLANK.getMessage());
        int result = Integer.parseInt(operations[0]);
        for (int i=1; i<operations.length; i+=2) {
            result = calculator.calculate(operations[i], result, Integer.parseInt(operations[i+1]));
        }

        RESULT_VIEW.showResult(result);
    }
}
