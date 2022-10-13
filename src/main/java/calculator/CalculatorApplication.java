package calculator;

import calculator.domain.CalcNumber;
import calculator.service.StringCalculatorService;
import calculator.view.InputView;

public class CalculatorApplication {
    public static void main(String[] args) {
        String input = InputView.input();
        CalcNumber result = StringCalculatorService.calculate(input);
        System.out.println("result = " + result.getNumber());
    }
}
