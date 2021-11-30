package com.kkambi.calculator;

import com.kkambi.calculator.domain.Formula;
import com.kkambi.calculator.domain.Numbers;

import java.util.List;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern GROUP_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String BASIC_DELIMITER = "[,:]";

    public static List<String> split(String formulaString) {
        Formula formula = new Formula(formulaString);
        formula.split(GROUP_PATTERN, BASIC_DELIMITER);
        return formula.getElements();
    }

    public static int sum(List<String> elements) {
        Numbers numbers = new Numbers(elements);
        return numbers.getNumbers()
                .stream()
                .reduce(0, (sumResult, number) -> sumResult + number.getNumber(), Integer::sum);
    }
}
