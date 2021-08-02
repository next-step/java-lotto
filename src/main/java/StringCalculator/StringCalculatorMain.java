package StringCalculator;

import StringCalculator.domain.AddingStrategy;
import StringCalculator.domain.OperationInputs;
import StringCalculator.domain.StringCalculator;
import StringCalculator.view.InputView;
import StringCalculator.view.ResultView;

public class StringCalculatorMain {

    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        String userInput = inputView.readUserInput();

        OperationInputs operationInputs = new OperationInputs(userInput, new AddingStrategy());

        StringCalculator calculator = new StringCalculator();
        int result = calculator.operate(operationInputs);

        ResultView resultView = ResultView.getInstance();
        resultView.printResult(result);

    }
}
