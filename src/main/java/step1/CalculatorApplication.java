package step1;

import step1.domain.StringCalculator;
import step1.view.InputView;
import step1.view.OutputView;

import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        String rawEquation = inputView.inputEquation();
        StringCalculator stringCalculator = StringCalculator.of(rawEquation);
        OutputView.printAnswer(stringCalculator.calculate());
    }
}
