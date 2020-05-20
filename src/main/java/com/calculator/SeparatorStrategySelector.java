package com.calculator;

import org.apache.commons.lang3.StringUtils;

public class SeparatorStrategySelector {

    private String inputText;

    public SeparatorStrategySelector(String inputText) {
        this.inputText = inputText;
    }

    public SeparatorStrategy selectSeparatorStrategy(String inputText) {
        if (isContainsCustomSeparator()) {
            return new CustomSeparator(inputText);
        }

        return new BaseSeparator(inputText);
    }

    private Boolean isContainsCustomSeparator() {
        return StringUtils.contains(this.inputText, CustomSeparator.PREFIX)
                && StringUtils.contains(this.inputText, CustomSeparator.POSTFIX);
    }
}
