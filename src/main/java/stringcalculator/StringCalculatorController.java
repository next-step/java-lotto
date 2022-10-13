package stringcalculator;

import stringcalculator.domain.Number;
import stringcalculator.domain.Operator;
import stringcalculator.io.StringCalculatorInput;

public class StringCalculatorController {

    public static Number calculate() {
        return calculate(StringCalculatorInput.input(" "));
    }

    private static Number calculate(String[] strings) {
        Number result = new Number(strings[0]);
        for (int i = 1; i < strings.length; i += 2) {
            Operator operator = new Operator(strings[i]);
            Number number = new Number(strings[i + 1]);
            StringCalculator.calculate(result, operator, number);
        }
        return result;
    }

}
