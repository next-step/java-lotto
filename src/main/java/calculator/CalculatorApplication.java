package calculator;

import calculator.domain.Operator;

import static calculator.view.InputView.inputNumber;
import static calculator.view.ResultView.resultCalculator;

public class CalculatorApplication {

    public static void main(String[] args) {
        System.out.println(Operator.valueOf("-"));
        Calculator calculator = new Calculator(inputNumber());
        resultCalculator(calculator.startCalculate());
    }
}
