package com.calc.controller;

import com.calc.model.StringAddCalculator;
import com.calc.view.InputView;
import com.calc.view.ResultView;

public class StringAddCalculatorMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();

        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        int result = stringAddCalculator.execute(inputView.getInputValue());

        ResultView resultView = new ResultView(result);
        resultView.print();
    }
}
