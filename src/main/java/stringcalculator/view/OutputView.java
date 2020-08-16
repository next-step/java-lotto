package stringcalculator.view;

import stringcalculator.expression.ExpressionNumber;

public class OutputView {
    public static void printResult(ExpressionNumber expressionNumber) {
        System.out.println(expressionNumber.getNumber());
    }
}
