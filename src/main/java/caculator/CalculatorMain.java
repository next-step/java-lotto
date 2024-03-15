package caculator;

import calculator.CalculatorController;

public class CalculatorMain {
    public static void main(String[] args) {
        new CalculatorController(new InputView(), new OutputView()).calculate();
    }
}
