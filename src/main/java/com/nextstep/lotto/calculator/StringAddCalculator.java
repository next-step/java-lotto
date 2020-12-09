package com.nextstep.lotto.calculator;

public class StringAddCalculator {
    private static final int ZERO = 0;

    private StringAddCalculator(){}

    public static int sum(String source) {
        if (source == null || "".equals(source)) {
            return ZERO;
        }
        Splitter splitter = Parser.parse(source);
        String[] numbers = splitter.split();
        return addNumbers(numbers);
    }

    private static int addNumbers(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += parsePositiveInt(number);
        }
        return result;
    }

    private static int parsePositiveInt(String number) {
        int result = Integer.parseInt(number);
        if (result < 0) {
            throw new RuntimeException(result + " is negative value");
        }
        return result;
    }
}
