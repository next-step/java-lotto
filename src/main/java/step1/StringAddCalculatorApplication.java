package step1;

import step1.controller.StringAddCalculatorController;
import step1.view.StringAddCalculatorUi;

public class StringAddCalculatorApplication {

    public static void main(String[] args) {
        String expression = StringAddCalculatorUi.inputExpression();
        StringAddCalculatorController addCalculator = StringAddCalculatorController.of(expression);
        StringAddCalculatorUi.resultPrint(addCalculator.getSum());
    }
}
