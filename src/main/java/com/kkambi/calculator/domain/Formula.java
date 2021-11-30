package com.kkambi.calculator.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formula {

    private final String formula;
    private List<String> elements;

    public Formula(String formula) {
        if (isEmpty(formula)) {
            this.formula = "0";
            return;
        }

        this.formula = formula;
    }

    public void split(Pattern groupPattern, String basicDelimiter) {
        Matcher matcher = groupPattern.matcher(formula);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            this.elements = Arrays.asList(matcher.group(2).split(customDelimiter));
            return;
        }
        this.elements = Arrays.asList(formula.split(basicDelimiter));
    }

    public List<String> getElements() {
        return Collections.unmodifiableList(elements);
    }

    private boolean isEmpty(String formula) {
        if (Objects.isNull(formula)) {
            return true;
        }

        return formula.isEmpty();
    }
}
