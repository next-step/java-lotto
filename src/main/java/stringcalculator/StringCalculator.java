package stringcalculator;

import java.util.List;
import stringcalculator.util.StringToIntUtil;

public class StringCalculator {

    private static final int EVEN_NUMBER = 2;

    private final Formula formula;

    public StringCalculator(List<String> texts) {
        formula = new Formula();
        for (int i = 0; i < texts.size(); i++) {
            addFormula(texts.get(i), formula, i);
        }
    }

    public int calculate() {
        return formula.calculate();
    }

    private void addFormula(String text, Formula formula, int i) {
        if (!isOddNumber(i)) {
            formula.addNumber(StringToIntUtil.apply(text));
        }
        if (isOddNumber(i)) {
            formula.addOperator(text);
        }
    }

    private boolean isOddNumber(int i) {
        return i % EVEN_NUMBER == 1;
    }
}
