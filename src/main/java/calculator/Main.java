package calculator;

import calculator.domain.Calculator;
import calculator.domain.UserInput;
import calculator.view.InputView;
import calculator.view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.createInput();
        UserInput userInput = inputView.getInput();

        int result = Calculator.calculate(userInput.getIntegers());

        ResultView resultView = new ResultView(result);
        resultView.print();
    }
}
