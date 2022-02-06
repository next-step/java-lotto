package calculator;

import calculator.domain.Calculator;
import calculator.view.InputView;

public class CalculatorApplication {

    public static void main(String[] args) {
        String text = InputView.inputText();

        Calculator calculator = new Calculator();
        System.out.println(calculator.add(text));
    }
}
