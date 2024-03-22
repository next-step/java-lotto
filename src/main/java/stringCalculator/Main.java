package stringCalculator;

import stringCalculator.domain.CalculationFormula;
import stringCalculator.domain.expression.Calculator;
import stringCalculator.view.Input;
import stringCalculator.view.Output;

public class Main {

    public static void main(String[] args) {

        CalculationFormula calculationFormula = new CalculationFormula(Input.inputNumericFormula());
        Calculator calculator = new Calculator();

        calculator.classifyOperators(calculationFormula.parseCalculationFormula());
        calculator.startCalculate();

        Output.printNumericFormula(calculator.getSum());
    }
}
