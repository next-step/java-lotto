package step1.controller;

import step1.domain.ArithmeticCalculatorService;
import step1.view.InputView;
import step1.view.OutputView;

public class ArithmeticCalculatorController {

    public static void main(String[] args) {
        String inputString = InputView.askArithmeticCalculator();

        ArithmeticCalculatorService arithmeticCalculatorService = ArithmeticCalculatorService.from(inputString);
        arithmeticCalculatorService.calculator();

        OutputView.outPut(arithmeticCalculatorService.getCalculatorResult());
    }
}
