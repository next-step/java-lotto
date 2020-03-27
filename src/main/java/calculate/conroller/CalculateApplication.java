package calculate.conroller;

import calculate.domain.Calculator;
import calculate.domain.UserInput;
import calculate.view.InputView;
import calculate.view.ResultView;

public class CalculateApplication {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.getUserInput();
        UserInput userInput = new UserInput(inputView.getInput());

        Calculator calculator = new Calculator(userInput.getPrimaloperand(), userInput.getDelimiter());
        int result = calculator.calculate();
        ResultView.printResult(result);
    }
}
