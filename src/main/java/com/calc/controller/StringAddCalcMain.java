package com.calc.controller;

import com.calc.model.StringAddCalculator;
import com.calc.view.StringAddCalcInputView;
import com.calc.view.StringAddCalcResultView;

public class StringAddCalcMain {

    public static void main(String[] args) {

        StringAddCalcInputView stringAddCalcInputView = new StringAddCalcInputView();

        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        int result = stringAddCalculator.execute(stringAddCalcInputView.getInputValue());

        StringAddCalcResultView stringAddCalcResultView = new StringAddCalcResultView(result);
        stringAddCalcResultView.print();
    }
}
