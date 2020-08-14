package calculator;

import calculator.domain.StringCalculator;
import calculator.view.InsertView;
import calculator.view.ResultView;

public class StringCalculatorApp {
    public static void main(String[] args) {
        ResultView.print(StringCalculator.splitAndSum(InsertView.inputText()));
    }
}
