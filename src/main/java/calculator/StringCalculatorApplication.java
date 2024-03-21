package calculator;

import comm.view.InputView;
import calculator.domain.Calculator;

public class StringCalculatorApplication {
    private static InputView inputView;
    private static Calculator calculator;


    public static void main(String[] args) {
        System.out.println(Calculator.calculate(inputView.requestOperation()));
    }

}
