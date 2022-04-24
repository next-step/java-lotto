package calculator.controller;

import calculator.model.Formula;
import calculator.model.Number;
import calculator.view.ResultView;

public class Calculator {

    public void calculate(Formula formula) {
        Number result = formula.calculate();
        ResultView.print(result.toString());
    }
}
