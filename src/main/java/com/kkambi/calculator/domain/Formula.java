package com.kkambi.calculator.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formula {

    private final String formula;

    public Formula(String formula) {
        if (isEmpty(formula)) {
            this.formula = "0";
            return;
        }

        this.formula = formula;
    }

    public Numbers convertToNumbers(Pattern groupPattern, String basicDelimiter) {
        Matcher matcher = groupPattern.matcher(formula);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return new Numbers(matcher.group(2).split(customDelimiter));
        }
        return new Numbers(formula.split(basicDelimiter));
    }

    private boolean isEmpty(String formula) {
        if (Objects.isNull(formula)) {
            return true;
        }

        return formula.isEmpty();
    }

}
