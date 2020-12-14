package calculator;

import calculator.view.InputView;
import calculator.view.ResultView;

public class MainApplication {

    public static void main(String[] args) {
        String mathExpression = InputView.inputMathExpression();
        StringAddCalculator stringAddCalculator = new StringAddCalculator(mathExpression);
        ResultView.printResult(stringAddCalculator.splitAndSum());
    }
}
