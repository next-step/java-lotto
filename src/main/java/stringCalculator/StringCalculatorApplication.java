package stringCalculator;

import stringCalculator.controller.StringCalculatorController;
import stringCalculator.domain.StringCalculator;
import stringCalculator.view.OutputHandler;
import stringCalculator.view.RequestView;

public class StringCalculatorApplication {
    private static final RequestView requestView = new RequestView();
    private static final OutputHandler outputHandler = new OutputHandler();

    public static void main(String[] args) {
        StringCalculatorController stringCalculatorController = new StringCalculatorController();
        StringCalculator calculator = requestInput();
        outputHandler.printResult(stringCalculatorController.calculate(calculator));
    }

    public static StringCalculator requestInput() {
        try {
            StringCalculator calculator = new StringCalculator(requestView.requestUserInput());
            return calculator;
        } catch (RuntimeException e) {
            outputHandler.printErrorNegativeNum();
            return requestInput();
        }
    }
}
