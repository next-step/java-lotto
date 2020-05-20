package com.calculator.selector;

import com.calculator.domain.CustomSeparator;
import com.calculator.domain.SeparatorStrategy;
import com.calculator.domain.BaseSeparator;
import org.apache.commons.lang3.StringUtils;

public class SeparatorStrategySelector {

    private String inputText;

    public SeparatorStrategySelector(String inputText) {
        this.inputText = inputText;
    }

    public SeparatorStrategy selectSeparatorStrategy() {
        if (isContainsCustomSeparator()) {
            return new CustomSeparator(this.inputText);
        }

        return new BaseSeparator(this.inputText);
    }

    private Boolean isContainsCustomSeparator() {
        return StringUtils.contains(this.inputText, CustomSeparator.PREFIX)
                && StringUtils.contains(this.inputText, CustomSeparator.POSTFIX);
    }
}
