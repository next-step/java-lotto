package stringaddcalculator;

import stringaddcalculator.view.InputView;
import stringaddcalculator.view.ResultView;

public class CalculatorApplication {

    public static void main(String[] args) {
        String expression = InputView.getExpression();
        int result = StringAddCalculator.splitAndSum(expression);
        ResultView.showResult(result);
    }
}
