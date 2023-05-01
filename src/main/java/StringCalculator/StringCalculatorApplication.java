package StringCalculator;

import StringCalculator.domain.StringCalculator;
import StringCalculator.view.CalculatorView;

public class StringCalculatorApplication {

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator(CalculatorView.inputExpression());
        CalculatorView.outputCalculate(calculator.calculate());
    }

}
