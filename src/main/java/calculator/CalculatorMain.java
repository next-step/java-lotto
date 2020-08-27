package calculator;

import static calculator.domain.InputValueProcessing.calculateInputValue;
import static calculator.view.InputView.inputString;

public class CalculatorMain {
    public static void main(String[] args) {
        System.out.println(calculateInputValue(inputString()));
    }
}
