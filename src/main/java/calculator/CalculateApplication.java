package calculator;

import calculator.view.InputView;
import calculator.view.ResultView;

import static calculator.Calculator.calculate;

public class CalculateApplication {
    public static void main(String[] args) {
        int resultValue = calculate(InputView.inputCalculateValue());
        ResultView.printResultValue(resultValue);
    }
}
