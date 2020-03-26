package calculator;

import calculator.domain.Numbers;
import calculator.domain.StringCalculatorFilter;

public class StringCalculator {
    public int splitAndSum(String input) {
        StringCalculatorFilter filter = new StringCalculatorFilter(input);
        String regex = filter.regexFromString();
        String body = filter.messageFromString();
        return new Numbers(body.split(regex)).sum();
    }
}
