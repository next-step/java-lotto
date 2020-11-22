package stringaddcalculator;

import stringaddcalculator.calculator.StringAddCalculator;
import stringaddcalculator.view.InputView;
import stringaddcalculator.view.ResultView;

public class StringAddCalculatorMain {
    public static void main(String[] args) {
        StringAddCalculator stringAddCalculator = new StringAddCalculator(new InputView(), new ResultView());
        stringAddCalculator.operator();
    }
}
