package calculator;

import calculator.service.StringCalculatorService;
import calculator.view.InputView;

public class CalculatorApplication {
    public static void main(String[] args) {
        String input = InputView.input();
        int result = StringCalculatorService.calculate(input);
        System.out.println("result = " + result);
    }
}
