package calculator;

import calculator.domain.StringCalculator;

public class CalculatorClient {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        stringCalculator.calculate();
    }
}
