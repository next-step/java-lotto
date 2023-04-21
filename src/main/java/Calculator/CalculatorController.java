package Calculator;

import Calculator.View.*;
import Calculator.Model.*;


public class CalculatorController {
    public void start() {
        System.out.println("계산기를 시작합니다.");

        String[] elements = InputView.getAlgebra();

        Calculator calculator = new Calculator();
        for (String element : elements) {
            calculator.type(element);
        }

        System.out.println("계산 결과는 " + calculator.currentResult() + "입니다.");
    }

}
