package calculator;

import calculator.controller.StringCalculator;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorMain {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator(InputView.requestText());
        ResultView.result(calculator.result());
    }
}
