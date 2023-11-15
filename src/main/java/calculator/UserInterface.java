package calculator;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.ResultView;

public class UserInterface {
    public static void main(String[] args) {
        String expression = InputView.expression();
        Calculator calculator = new Calculator(expression);
        ResultView.calculateResult(calculator.calculate());
    }
}
