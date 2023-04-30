package domain;

import view.InputView;

import java.util.List;

public class StringCalculatorMain {
    public static void main(String[] args) {

        StringCalculator stringCalculator = new StringCalculator();

        String expression = InputView.readExpression();
        stringCalculator.validExpression(expression);
        List<Integer> numbers = stringCalculator.extractNumbers(expression);
        List<Operation> operations = stringCalculator.extractOperation(expression);


        int result = stringCalculator.calculate();
        System.out.println(">>> " + result);
    }


}
