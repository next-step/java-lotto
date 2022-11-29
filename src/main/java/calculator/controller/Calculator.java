package calculator.controller;

import calculator.domain.Expression;
import calculator.view.Input;
import calculator.view.Output;

import java.util.List;

public class Calculator {

    public void start() {
        Output.printQuestion();

        List<String> rawExpression = Input.readExpression();
        Expression expression = new Expression(rawExpression);

        Output.printAnswer(expression.calculate());
    }
}
