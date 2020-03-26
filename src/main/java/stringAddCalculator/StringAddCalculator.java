package stringAddCalculator;

import stringAddCalculator.model.Expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(Expression expression) {
        String[] numbers = expression.split();

        Integer result = 0;
        for(String numberString : numbers) {
            Integer number = Integer.parseInt(numberString);
            if(number < 0) {
                throw new RuntimeException("음수 포함");
            }
            result += number;
        }
        return result;
    }
}
