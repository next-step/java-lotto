package calculator;

import calculator.domain.Numbers;
import calculator.domain.StringCalculatorParser;

public class StringCalculator {
    public int splitAndSum(String input) {
        StringCalculatorParser parser = new StringCalculatorParser(input);
        return new Numbers(parser.parse()).sum();
    }
}
