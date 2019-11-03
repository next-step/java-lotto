package step1;

import step1.Domain.Calculator;
import step1.View.InputView;
import step1.View.ResultView;

public class Application {
    public static void main(String[] args) {
        String input = InputView.inputDate();
        Calculator calculator = new Calculator(input);
        Integer calculatorSum = calculator.sum();
        ResultView.printData(calculatorSum);

    }
}
