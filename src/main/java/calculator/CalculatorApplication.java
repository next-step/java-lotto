package calculator;

import calculator.domain.Calculator;
import calculator.domain.InputValue;
import calculator.service.CalculatorService;
import calculator.util.MessageConverter;
import calculator.view.InputScanner;

import java.util.List;
import java.util.Scanner;

/**
 * Created by seungwoo.song on 2022-09-28
 */
public class CalculatorApplication {

    public static void main(String[] args) {
        InputScanner inputScanner = new InputScanner(new Scanner(System.in));
        CalculatorService calculatorService = new CalculatorService(new Calculator());
        MessageConverter messageConverter = new MessageConverter();

        int result = calculatorService.calculate(messageConverter.convert(inputScanner.scan()));

        System.out.println(result);
    }
}
