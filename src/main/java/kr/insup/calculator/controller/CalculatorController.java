package kr.insup.calculator.controller;

import kr.insup.calculator.domain.Calculator;
import kr.insup.calculator.view.CalculatorView;

public class CalculatorController {

    public static void main(String[] args){

        Calculator calculator = new Calculator();

        String input = CalculatorView.getInput();
        int result = calculator.calculate(input);
        CalculatorView.showResult(result);
    }

}
