package calculator;

import calculator.domain.Calculator;
import common.view.CalculatorInputView;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        System.out.println(Calculator.calculate(CalculatorInputView.requestOperation()));
    }

}
