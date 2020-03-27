package stringpluscalculator;

import java.util.Arrays;

public class Formula {
    private String[] formula;

    public Formula(String input, String separators) {
        this.formula = validateFormula(input.split(separators));
    }

    public int sum() {
        return Arrays.stream(formula)
                .mapToInt(Integer::parseInt)
                .reduce(0, Integer::sum);
    }

    private String[] validateFormula(String[] input) {
        for (String s : input) {
            validateNumber(s);
        }
        return input;
    }

    private void validateNumber(String input) {
        try {
            validatePositiveNumber(Integer.parseInt(input));
        } catch (NumberFormatException nfe) {
            throw new RuntimeException("수식 중 숫자가 아닌것이 있습니다.");
        }
    }

    private void validatePositiveNumber(int input) {
        if (input < 0) {
            throw new RuntimeException("수식 중 양수가 아닌것이 있습니다.");
        }
    }
}
