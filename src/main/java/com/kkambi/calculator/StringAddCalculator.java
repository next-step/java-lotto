package com.kkambi.calculator;

import com.kkambi.calculator.domain.Formula;
import com.kkambi.calculator.domain.Numbers;

import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern GROUP_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String BASIC_DELIMITER = "[,:]";

    public static int splitAndSum(String formulaString) {
        Formula formula = new Formula(formulaString);
        Numbers numbers = formula.convertToNumbers(GROUP_PATTERN, BASIC_DELIMITER);
        return numbers.getNumbers()
                .stream()
                .reduce(0, Integer::sum);
    }
}
