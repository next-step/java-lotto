package com.calculator.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class BaseSeparator implements SeparatorStrategy {

    @Override
    public List<String> getSeparatedInputs(String inputText) {
        String[] splitInput = StringUtils.split(
                inputText, BaseSeparatorType.COMMA.getSymbol() + "|" + BaseSeparatorType.COLON.getSymbol()
        );
        return Arrays.asList(splitInput);
    }

    private enum BaseSeparatorType {
        COMMA(","),
        COLON(":");

        private String symbol;

        BaseSeparatorType(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }
}
