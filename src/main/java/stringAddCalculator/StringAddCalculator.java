package stringAddCalculator;

import stringAddCalculator.model.Expression;
import stringAddCalculator.model.Numbers;

public class StringAddCalculator {

    public static int splitAndSum(Expression expression) {
        Numbers numbers = expression.split();
        return numbers.sum();
    }
}
