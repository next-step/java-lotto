package calculator;

import java.util.List;

public class StringCalculator {
    private StringCalculator() {
    }

    public static int calculate(String text) {
        List<String> elements = SplitString.split(text);
        int resultValue = Integer.parseInt(elements.get(0));
        for (int index = 1; index < elements.size(); index += 2) {
            Calculator calculator = Calculator.valueOfOperator(elements.get(index));
            resultValue = calculator.calculate(resultValue, getOperand(elements.get(index + 1)));
        }
        return resultValue;
    }

    private static int getOperand(String value) {
        return Integer.parseInt(value);
    }
}
