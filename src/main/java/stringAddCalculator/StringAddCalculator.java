package stringAddCalculator;

import stringAddCalculator.model.Expression;
import stringAddCalculator.model.Numbers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(Expression expression) {
        Numbers numbers = expression.split();
        return numbers.sum();
    }
}
