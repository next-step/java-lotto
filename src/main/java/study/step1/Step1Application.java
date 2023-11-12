package study.step1;

import study.step1.domain.Calculator;

import static study.step1.view.InputView.input;
import static study.step1.view.ResultView.result;

public class Step1Application {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(input());
        result(calculator.calculate());
    }
}
