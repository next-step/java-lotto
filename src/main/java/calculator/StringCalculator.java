package calculator;

import java.util.List;

public class StringCalculator {
    private StringCalculator() {
    }

    public static int calculate(String text) {
        List<String> elements = SplitString.split(text);
        int result = Integer.parseInt(elements.get(0));
        for (int i = 1; i < elements.size(); i++) {
            if (elements.get(i).equals("+")) {
                result = Calculator.plus(result, Integer.parseInt(elements.get(i + 1)));
            }
            if (elements.get(i).equals("-")) {
                result = Calculator.minus(result, Integer.parseInt(elements.get(i + 1)));
            }
            if (elements.get(i).equals("*")) {
                result = Calculator.multiply(result, Integer.parseInt(elements.get(i + 1)));
            }
            if (elements.get(i).equals("/")) {
                result = Calculator.divide(result, Integer.parseInt(elements.get(i + 1)));
            }
        }
        return result;
    }
}
