package calculator;

import calculator.domain.*;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorApplication {

    public static void main(String[] args) {

        final Expression expression = new Expression(InputView.input());
        final Expressions expressions = new Expressions(expression);
        final CalculationResult calculationResult = CalculationResult.init();
        calculationResult.calculate(expressions);

        ResultView.resultTitlePrint();
        ResultView.resultPrint(calculationResult);
    }
}