package stringCalculator.controller;

import stringCalculator.domain.Operand;
import stringCalculator.view.InputView;
import stringCalculator.view.OutputView;

public class StringCalculatorController {
    public static void main(String[] args) {
        String toCalculate = InputView.toCalculateString();
        Operand operand = new Operand(toCalculate);
        OutputView.result(operand.calculate());
    }
}
