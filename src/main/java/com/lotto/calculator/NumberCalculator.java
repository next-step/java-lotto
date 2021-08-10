package com.lotto.calculator;

import java.util.Arrays;

public class NumberCalculator {
    public static int sum(String input) {
        return Arrays.stream(NumberSplitter.split(input)).sum();
    }
}
