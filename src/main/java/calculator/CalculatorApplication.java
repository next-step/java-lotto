package calculator;

import java.util.Arrays;
import java.util.List;

import static calculator.view.InputView.inputNumber;
import static calculator.view.ResultView.resultCalculator;

public class CalculatorApplication {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(inputNumber());
        resultCalculator(calculator.start());
    }
}
