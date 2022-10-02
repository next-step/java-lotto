package calculator;

import calculator.domain.*;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorApplication {

    public static void main(String[] args) {

        final Expression expression = new Expression(InputView.expression());
        final CalculationResult calculationResult = CalculationResult.init();
        calculationResult.calculate(new Expressions(expression));

        ResultView.resultTitlePrint();
        ResultView.resultPrint(calculationResult);
    }
}