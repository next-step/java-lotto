package step1;

import step1.enumeration.Operator;
import step1.model.NumberCalculation;

import static step1.view.ClientView.scanCalculationFormula;
import static step1.view.ClientView.showResult;

public class Calculator {
    public static void main(String[] args) {
        final String[] calculationFormula = scanCalculationFormula();

        final NumberCalculation result = new NumberCalculation(calculationFormula[0]);

        for (int i = 1; i < calculationFormula.length - 1; i += 2) {
            Operator operator = Operator.findByOperator(calculationFormula[i]);
            int number = Integer.parseInt(calculationFormula[i + 1]);

            operator.calculate(result, number);
        }

        showResult(result);
    }
}
