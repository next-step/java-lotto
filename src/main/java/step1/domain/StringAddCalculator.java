package step1.domain;

import step1.util.InputUtil;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        return InputUtil.getNumbers(input).sum();
    }
}
