package step1.calc.view;

import step1.calc.calculator.Calculator;

public class ResultView {

    private Calculator calculator;

    public ResultView(Calculator calculator) {
        this.calculator = calculator;
    }

    public void printResult() {
        System.out.println(calculator.calculate().operand());
    }
}
