package study.lotto.step1;

import study.lotto.step1.application.StringCalculator;
import study.lotto.step1.presentation.ConsoleInput;

public class StringCalculatorApplication {
    public static void main(String[] args) {
        String expression = ConsoleInput.expressionFromConsole();
        System.out.println(StringCalculator.calculate(expression));
    }
}
