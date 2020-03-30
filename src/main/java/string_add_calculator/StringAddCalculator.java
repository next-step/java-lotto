package string_add_calculator;

import string_add_calculator.model.Expression;
import string_add_calculator.model.Number;
import string_add_calculator.model.Numbers;

public class StringAddCalculator {

    public static Number splitAndSum(final Expression expression) {
        Numbers numbers = expression.split();
        return numbers.sum();
    }
}
