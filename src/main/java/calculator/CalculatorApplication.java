package calculator;

import calculator.service.StringCalculatorService;
import calculator.view.InputView;

import java.util.List;

public class CalculatorApplication {
    public static void main(String[] args) {
        String input = InputView.input();
        List<String> operations = StringCalculatorService.getOperations(input);
        int number = StringCalculatorService.calculate(operations).getNumber();
        System.out.println("number = " + number);
    }
}
