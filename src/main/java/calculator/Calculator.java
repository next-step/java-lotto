package calculator;

import calculator.domain.StringAdderCalculator;
import calculator.view.InputView;
import calculator.view.ResultView;

public class Calculator {
    public static void main(String[] args) {
        String userInput = InputView.getUserInput();

        StringAdderCalculator stringAdderCalculator = new StringAdderCalculator();
        int result = stringAdderCalculator.sum(userInput);

        ResultView.displayResult(result);
    }
}
