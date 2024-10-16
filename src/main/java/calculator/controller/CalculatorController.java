package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorController {

    public static void main(String[] args) {
        String calculationString = InputView.inputCalculationString();

        int result = CalculatorService.calculate(calculationString);

        ResultView.printResult(result);
    }

}
