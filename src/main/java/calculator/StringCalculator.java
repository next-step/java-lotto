package calculator;

import java.util.List;

public class StringCalculator {
    private static final int FIRST_OPERAND = 0;
    private static final int SECOND_OPERATOR = 1;
    private static final int TWO_STEP_INDEX = 2;
    private static final int GET_OPERAND = 1;

    private StringCalculator() {
    }

    public static int stringCalculate(String text) {
        List<String> elements = SplitString.split(text);
        int resultValue = getValidOperand(elements.get(FIRST_OPERAND));
        for (int index = SECOND_OPERATOR; index < elements.size(); index += TWO_STEP_INDEX) {
            resultValue = calculate(
                    new Operand(resultValue),
                    getValidOperator(elements.get(index)),
                    new Operand(elements.get(index + GET_OPERAND))
            );
        }
        return resultValue;
    }

    private static int calculate(Operand operand1, Operator operator, Operand operand2) {
        Expression expression = new Expression(operand1, operator, operand2);
        return expression.operation();
    }

    private static Operator getValidOperator(String operatorSymbol) {
        return Operator.valueOfOperatorSymbol(operatorSymbol);
    }

    private static int getValidOperand(String value) {
        return new Operand(value).getNumber();
    }
}
