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
        // ???????????????????????? 당황스
        System.out.print(userInput);

        outputHandler.printResult(calculator.add(userInput));

    }
}
