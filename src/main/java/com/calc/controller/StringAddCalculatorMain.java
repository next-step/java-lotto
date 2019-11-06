package com.calc.controller;

import com.calc.model.StringAddCalculator;
import com.calc.view.InputView;
import com.calc.view.ResultView;

import java.util.Scanner;

public class StringAddCalculatorMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();

        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        int result = stringAddCalculator.add(inputView.getInputValue());

        ResultView resultView = new ResultView(result);
        resultView.print();
    }
}
