package step1.application;

import step1.domain.ArithmeticExpression;
import step1.domain.Calculator;
import step1.domain.Number;
import step1.domain.Numbers;
import step1.domain.Operators;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ArithmeticExpression arithmeticExpression = new ArithmeticExpression(inputView.input());

        Numbers numbers = arithmeticExpression.numbers();
        Operators operators = arithmeticExpression.operators();

        Number number = numbers.pollNumber();


        while (numbers.size() != 1) {
            Number pollNumber = numbers.pollNumber();
            number = Calculator.findBy(operators.operator())
                .apply(number, pollNumber);
        }
        number = Calculator.findBy(operators.operator())
            .apply(number, numbers.pollNumber());

        OutputView outputView = new OutputView(number);
        outputView.result();


    }
}
