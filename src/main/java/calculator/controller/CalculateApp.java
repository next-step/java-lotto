package calculator.controller;

import calculator.domain.StringCalculator;
import calculator.view.InputView;

public class CalculateApp {
    public static void main(String[] args) {

        final String input = InputView.input();

        final StringCalculator stringCalculator = new StringCalculator(input);

        System.out.println(stringCalculator.cal());
    }
}
