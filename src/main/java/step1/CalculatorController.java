package step1;

import step1.domain.Calculator;
import step1.domain.Expression;
import step1.utils.CalculatorScanner;

public class CalculatorController {
    public int run() {
        Expression expression = CalculatorScanner.getInput();
        return Calculator.calculate(expression);
    }
}
