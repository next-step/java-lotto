package calculator;

import static calculator.domain.InputValue.inputValueValidate;
import static calculator.view.InputView.inputString;

public class CalculatorMain {
    public static void main(String[] args) {
        System.out.println(inputValueValidate(inputString()));
    }
}
