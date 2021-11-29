package com.kkambi.calculator;

import com.kkambi.calculator.domain.Elements;
import com.kkambi.calculator.domain.Formula;
import com.kkambi.calculator.domain.Numbers;

import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern GROUP_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String BASIC_DELIMITER = "[,:]";

    public static Elements split(String formulaString) {
        Formula formula = new Formula(formulaString);
        return formula.split(GROUP_PATTERN, BASIC_DELIMITER);
    }

    public static int sum(Elements elements) {
        Numbers numbers = new Numbers(elements);
        return numbers.getNumbers()
                .stream()
                .reduce(0, (sumResult, number) -> sumResult + number.getNumber(), Integer::sum);
    }
}
