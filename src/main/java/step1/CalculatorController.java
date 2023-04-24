package step1;

import step1.domain.Calculator;
import step1.domain.Expression;
import step1.utils.CalculatorScanner;

public class CalculatorController {
    public void run(){
        Expression expression = CalculatorScanner.getInput();
        int result = Calculator.calculate(expression);
        System.out.println(result);
    }
}
