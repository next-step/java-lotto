package calculator;

import calculator.domain.CalculateResult;
import calculator.domain.Calculator;

import java.util.Scanner;

/**
 * Created by seungwoo.song on 2022-09-28
 */
public class CalculatorRunner {

    public static void main(String[] args) {
        InputScanner inputScanner = new InputScanner(new Scanner(System.in));
        Calculator calculator = new Calculator(new CalculateResult());
        System.out.println(calculator.calculate(inputScanner.scan()));
    }
}
