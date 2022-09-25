package calculator;

import calculator.domain.StringAddCalculator;
import calculator.view.InputView;
import calculator.view.ResultView;

import java.util.Scanner;

public class Calculator {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        InputView.input();
        final StringAddCalculator stringAddCalculator = StringAddCalculator.from(scanner.nextLine());
        ResultView.resultTitlePrint();
        ResultView.resultPrint(stringAddCalculator.calculator());
    }
}
