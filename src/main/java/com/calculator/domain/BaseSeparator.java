package com.calculator.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class BaseSeparator implements SeparatorStrategy {

    private String inputText;

    public BaseSeparator(String inputText) {
        this.inputText = inputText;
    }

    @Override
    public List<String> getSeparatedInputs() {
        String[] splitInput = StringUtils.split(
                this.inputText, BaseSeparatorType.COMMA.getSymbol() + "|" + BaseSeparatorType.COLON.getSymbol()
        );
        return Arrays.asList(splitInput);
    }

    private enum BaseSeparatorType {
        COMMA(","),
        COLON(";");

        private String symbol;

        BaseSeparatorType(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }
}
