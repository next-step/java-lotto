package step1;

import step1.model.enumeration.Operator;
import step1.model.NumberCalculation;

import static step1.view.ClientView.scanCalculationFormula;
import static step1.view.ClientView.showResult;

public class Calculator {
    public static void main(String[] args) {
        final String[] calculationFormula = scanCalculationFormula();

        final NumberCalculation result = new NumberCalculation(calculationFormula[0]);

        for (int i = 1; i < calculationFormula.length - 1; i += 2) {
            Operator.getOperator(calculationFormula[i])
                    .calculate(result, calculationFormula[i + 1]);
        }

        showResult(result);
    }
}
