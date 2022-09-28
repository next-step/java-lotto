package stringcalculator.service;

import stringcalculator.domain.Number;
import stringcalculator.domain.Operator;
import stringcalculator.domain.calculator.Calculator;

public class StringCalculatorService {

    public int calculate(String[] inputs) {
        Number result = new Number(inputs[0]);

        for (int i = 1; i < inputs.length; i++) {
            Calculator calculator = Operator.get(inputs[i]);
            Number number = new Number(inputs[2]);
            result = calculator.calculate(result, number);
        }

        return result.getValue();

    }
}
