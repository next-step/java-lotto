package stringcalculator.controller;

import stringcalculator.service.StringCalculatorService;
import stringcalculator.view.InputView;
import stringcalculator.view.OutputView;

public class StringCalculatorController {

    public static void main(String[] args) {
        StringCalculatorService service = new StringCalculatorService();

        String expression = InputView.askExpression();
        int result = service.calculate(expression.split(" "));
        OutputView.printResult(result);
    }

}
