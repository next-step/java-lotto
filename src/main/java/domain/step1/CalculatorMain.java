package domain.step1;

import view.InputView;

public class CalculatorMain {
    public static void main(String[] args) {

        StringCalculator stringCalculator = new StringCalculator();

        String expression = InputView.readExpression();
        validExpression(expression);

        System.out.println(">>> " + stringCalculator.calculate(readNumbers(expression), readOperators(expression)));
    }

    static void validExpression(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException("유효한 표현식이 아닙니다.");
        }
    }

    static Operations readOperators(String expression) {
        OperatorFactory operatorFactory = new OperatorFactory();
        return new Operations(operatorFactory.extractList(splitByBlank(expression)));
    }

    static Numbers readNumbers(String expression) {
        CalculatorTokenFactory numbersFactory = new NumbersFactory();
        return new Numbers(numbersFactory.extractList(splitByBlank(expression)));
    }

    private static String[] splitByBlank(String expression) {
        return expression.split(" ");
    }


}
