package stringCalculator;

import stringCalculator.domain.StringCalculator;
import stringCalculator.view.InputHandler;
import stringCalculator.view.OutputHandler;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();
        StringCalculator calculator = new StringCalculator();
        String userInput = inputHandler.requestUserInput();

        try {
            outputHandler.printResult(calculator.add(userInput));
        } catch (RuntimeException ex) {
            outputHandler.printNegativeNumberError();
            System.exit(0);
        }
    }
}
