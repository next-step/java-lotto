package calculator;

import java.util.List;

public class StringCalculator {
    private static final int FIRST_OPERAND = 0;
    private static final int SECOND_OPERATOR = 1;
    private static final int TWO_STEP_INDEX = 2;
    private static final int GET_OPERAND = 1;

    private StringCalculator() {
    }

    public static int calculate(String text) {
        List<String> elements = SplitString.split(text);
        Operand resultValue = new Operand(elements.get(FIRST_OPERAND));
        for (int index = SECOND_OPERATOR; index < elements.size(); index += TWO_STEP_INDEX) {
            Operator operator = Operator.valueOfOperatorSymbol(elements.get(index));
            resultValue = operator.operate(resultValue, new Operand(elements.get(index + GET_OPERAND)));
        }
        return resultValue.getNumber();
    }
}
