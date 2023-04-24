package calculator;

import calculator.View.*;
import calculator.Model.*;


public class CalculatorController {
    public void start() {
        CalculatorElements elements = InputView.algebra();

        Calculator calculator = new Calculator(elements);
        int result = calculator.execute();

        System.out.println("계산 결과는 " + result + "입니다.");
    }
}
