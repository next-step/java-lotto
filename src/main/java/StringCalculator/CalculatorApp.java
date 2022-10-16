package StringCalculator;

import StringCalculator.backend.controller.CalculatorController;
import StringCalculator.frontend.InputView;
import StringCalculator.frontend.ResultView;

public final class CalculatorApp {

    public static void main(String[] args) {
        String numberSentence = InputView.askNumberSentence();
        CalculatorController calculatorController = new CalculatorController();
        int sum = calculatorController.run(numberSentence);
        ResultView.print(sum);
    }
}
