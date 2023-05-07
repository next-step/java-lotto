package stringCalculator.controller;

import stringCalculator.domain.Calculator;
import stringCalculator.view.InputView;
import stringCalculator.view.ResultView;

import java.util.Scanner;

public class CalculatorController {

    private static final InputView inputView = new InputView(new Scanner(System.in));
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        calculator();
    }

    public static void calculator() {

        String inputText = inputView.setOperateText();

        Calculator calculator = new Calculator(inputText);

        resultView.result(calculator.calculate());
    }
}
