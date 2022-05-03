package calculator;

import calculator.model.Formula;

public class Main {

    public static void main(String args[]) {
        StringCalculator calculationString = new StringCalculator(new Formula("2 + 3 * 4 / 2"));
        calculationString.start();
    }
}
