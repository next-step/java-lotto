package stringaddcalculator;

import stringaddcalculator.model.Expression;
import stringaddcalculator.model.Number;
import stringaddcalculator.model.Numbers;

public class StringAddCalculator {

    public static Number splitAndSum(final Expression expression) {
        Numbers numbers = expression.split();
        return numbers.sum();
    }
}
