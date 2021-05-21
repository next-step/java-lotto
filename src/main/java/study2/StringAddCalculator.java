package study2;

import study2.domain.StringCalculator;

public class StringAddCalculator {
    public int splitAndSum(String input) {
        StringCalculator stringCalculator = new StringCalculator(input);
        return stringCalculator.sum();
    }
}
