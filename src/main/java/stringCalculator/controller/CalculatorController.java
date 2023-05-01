package stringCalculator.controller;

import stringCalculator.domain.Calculator;
import stringCalculator.view.InputView;
import stringCalculator.view.ResultView;

import java.util.Scanner;

public class CalculatorController {

    public static void main(String[] args) {
        calculator();
    }

    public static void calculator() {

        InputView inputView = new InputView(new Scanner(System.in));
        ResultView resultView = new ResultView();

        String inputText = inputView.setOperateText();

        Calculator calculator = new Calculator(inputText);

        resultView.result(calculator.calculate());
    }
}
