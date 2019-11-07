package com.lotto.controller;

import com.lotto.model.StringAddCalculator;
import com.lotto.view.StringAddCalculatorInputView;
import com.lotto.view.StringAddCalculatorResultView;

public class StringAddCalcMain {

    public static void main(String[] args) {

        StringAddCalculatorInputView stringAddCalculatorInputView = new StringAddCalculatorInputView();

        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        int result = stringAddCalculator.execute(stringAddCalculatorInputView.getInputValue());

        StringAddCalculatorResultView stringAddCalculatorResultView = new StringAddCalculatorResultView(result);
        stringAddCalculatorResultView.print();
    }
}
