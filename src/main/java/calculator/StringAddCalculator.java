package calculator;

import calculator.domain.*;
import calculator.view.InputView;
import calculator.view.ResultView;

public class StringAddCalculator {

    public static void main(String[] args) {

        final StringInput input = new StringInput(InputView.input());
        final Expressions expressions = new Expressions(input.split());
        final Operators operators = expressions.extract();
        ResultView.resultTitlePrint();
        ResultView.resultPrint(operators.finalOperate(expressions));
    }
}
