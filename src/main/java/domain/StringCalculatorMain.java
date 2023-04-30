package domain;

import view.InputView;

public class StringCalculatorMain {
    public static void main(String[] args) {

        StringCalculator stringCalculator = new StringCalculator();

        String expression = InputView.readExpression();
        stringCalculator.validExpression(expression);
        Numbers numbers = stringCalculator.extractNumbers(expression);
        Operations operations = stringCalculator.extractOperation(expression);

        System.out.println(">>> " + stringCalculator.calculate(numbers, operations));
    }


}
