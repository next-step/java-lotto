package calculator;

import java.util.List;

public class StringCalculator {
    private static final int FIRST_OPERAND_INDEX = 0;
    private StringCalculator() {
    }

    public static int calculate(String text) {
        List<String> elements = SplitString.split(text);
        Operand resultValue = new Operand(elements.get(FIRST_OPERAND_INDEX));
        for (int index = 1; index < elements.size(); index += 2) {
            Operator operator = Operator.valueOfOperatorSymbol(elements.get(index));
            resultValue = operator.operate(resultValue, new Operand(elements.get(index + 1)));
        }
        return resultValue.getNumber();
    }
}
