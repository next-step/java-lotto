package stringpluscalculator;

public class Formula {
    private String[] formula;

    public Formula(String input, String separators) {
        this.formula = input.split(separators);
        validateFormula();
    }

    private void validateFormula() {
        for (String s : formula) {
            validateNumber(s);
        }
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
