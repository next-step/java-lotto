package stringcalculator.service;

import stringcalculator.domain.Number;
import stringcalculator.domain.Operator;
import stringcalculator.domain.calculator.Calculator;

public class StringCalculatorService {

    public int calculate(String[] inputs) {
        Number result = new Number(inputs[0]);

        int i = 0;
        while (i < inputs.length - 1) {
            Calculator calculator = Operator.get(inputs[++i]);
            Number number = new Number(inputs[++i]);
            result = calculator.calculate(result, number);
        }

        return result.getValue();

    }
}
