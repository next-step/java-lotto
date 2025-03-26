package calculator;

import calculator.domain.Calculator;
import calculator.domain.Number;

public class StringCalculatorMain {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Number result = calculator.calculate(InputView.getCalculationFormula());
        System.out.println("계산 결과: " + result.getValue());
    }
}
