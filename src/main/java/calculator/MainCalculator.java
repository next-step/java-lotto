package calculator;

import calculator.domain.StringCalculator;
import calculator.ui.InputHandler;

import java.util.Scanner;

public class MainCalculator {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();

        String inputString = InputHandler.INSTANCE.readLine();
        System.out.println(stringCalculator.calculate(inputString));
    }
}
