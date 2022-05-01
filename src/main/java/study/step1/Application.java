package study.step1;

import study.step1.domain.Formula;
import study.step1.domain.StringCalculator;
import study.step1.view.InputView;
import study.step1.view.ResultView;

import java.util.Scanner;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Formula formula = InputView.inputStringFromUser();
        StringCalculator stringCalculator = StringCalculator.of(formula);
        stringCalculator.setUp();
        String result = stringCalculator.start();
        ResultView.print(result);
    }
}
