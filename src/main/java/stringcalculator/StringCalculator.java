package stringcalculator;

import java.util.List;
import stringcalculator.util.StringToIntUtil;

public class StringCalculator {

    private static final int EVEN_NUMBER = 2;

    private StringCalculator() {
    }

    public static int calculate(List<String> texts) {
        Formula formula = new Formula();
        for (int i = 0; i < texts.size(); i++) {
            addFormula(texts.get(i), formula, i);
        }
        return formula.calculate();
    }

    private static void addFormula(String text, Formula formula, int i) {
        if (!isOddNumber(i)) {
            formula.addNumber(StringToIntUtil.apply(text));
        }
        if (isOddNumber(i)) {
            formula.addOperator(text);
        }
    }

    private static boolean isOddNumber(int i) {
        return i % EVEN_NUMBER == 1;
    }
}
