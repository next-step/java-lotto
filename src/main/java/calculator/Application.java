package calculator;

import static calculator.domain.Calculator.calculator;
import static calculator.view.inputView.inputData;
import static calculator.view.resultView.showResult;

public class Application {
    public static void main(String[] args) {
        showResult(calculator(inputData()));
    }
}
