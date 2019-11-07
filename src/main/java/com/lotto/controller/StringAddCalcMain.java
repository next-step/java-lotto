package com.lotto.controller;

import com.lotto.model.StringAddCalculator;
import com.lotto.view.StringAddCalcInputView;
import com.lotto.view.StringAddCalcResultView;

public class StringAddCalcMain {

    public static void main(String[] args) {

        StringAddCalcInputView stringAddCalcInputView = new StringAddCalcInputView();

        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        int result = stringAddCalculator.execute(stringAddCalcInputView.getInputValue());

        StringAddCalcResultView stringAddCalcResultView = new StringAddCalcResultView(result);
        stringAddCalcResultView.print();
    }
}
