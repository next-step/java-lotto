package com.calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Calculator {

    private static final Integer DEFAULT_NULL_OR_EMPTY_VALUE = 0;

    private String inputText;
    private CalculatorElement calculatorElement;
    private SeparatorStrategy separatorStrategy;


    public Calculator(String inputText) {
        this.inputText = inputText;
        this.calculatorElement = new CalculatorElement();
        this.separatorStrategy = new SeparatorStrategySelector(inputText).selectSeparatorStrategy();

    }

    public Integer calculate() {

        if (StringUtils.isEmpty(this.inputText)) {
            return DEFAULT_NULL_OR_EMPTY_VALUE;
        }

        List<String> elements = this.separatorStrategy.getSeparatedInputs();
        this.calculatorElement.convertElements(elements);
        this.calculatorElement.validateElements();

        return this.calculatorElement.addAllElements();
    }
}
