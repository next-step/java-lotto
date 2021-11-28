package calculator;

import calculator.controller.StringCalculator;
import calculator.ui.StringCalculatorView;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        StringCalculator calculator = StringCalculator.getInstance();
        StringCalculatorView view = StringCalculatorView.getInstance();

        String expression = view.input();

        view.output(calculator.execute(expression));
    }
}
