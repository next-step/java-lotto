package calculator;

import domain.StringAdderCalculator;
import view.InputView;
import view.ResultView;

public class Calculator {
    public static void main(String[] args) {
        String userInput = InputView.getUserInput();

        StringAdderCalculator stringAdderCalculator = new StringAdderCalculator();
        int result = stringAdderCalculator.sum(userInput);

        ResultView.displayResult(result);
    }
}
