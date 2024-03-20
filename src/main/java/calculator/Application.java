package calculator;

import static calculator.domain.Calculator.calculator;
import static calculator.view.InputView.inputData;
import static calculator.view.ResultView.showResult;

public class Application {
    public static void main(String[] args) {
        showResult(calculator(inputData()));
    }
}
