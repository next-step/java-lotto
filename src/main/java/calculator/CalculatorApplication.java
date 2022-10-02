package calculator;

import calculator.domain.Calculator;
import calculator.service.CalculatorService;

import java.util.Scanner;

/**
 * Created by seungwoo.song on 2022-09-28
 */
public class CalculatorApplication {

    public static void main(String[] args) {
        InputScanner inputScanner = new InputScanner(new Scanner(System.in));
        CalculatorService calculatorService = new CalculatorService(new Calculator());
        System.out.println(calculatorService.calculate(inputScanner.scan()));
    }
}
