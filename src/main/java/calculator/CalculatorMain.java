package calculator;

import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorMain {

    public static void main(String[] args) {
        String inputString = InputView.inputString();

        int resultNumber = CalculatorLogic.calculatorLogic(inputString);

        ResultView.printResult(resultNumber);
    }

}
