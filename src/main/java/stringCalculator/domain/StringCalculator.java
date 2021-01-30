package stringCalculator.domain;

import java.util.Arrays;
import stringCalculator.util.Utility;

public class StringCalculator {

    private String equation;
    private String[] equations;

    public StringCalculator(String equation) {
        this.equation = equation;
    }

    private void splitEquation() {
        Utility utility = new Utility();
        equations = utility.splitEquation(equation);
    }

    public int add() {
        if (Utility.isEquationEmpty(equation)) {
            return 0;
        }
        splitEquation();
        validatePositiveNum();
        return calculateSum(equations);
    }

    public void validatePositiveNum() throws RuntimeException {
        splitEquation();
        if (Arrays.stream(equations).map(Integer::parseInt).anyMatch(equation -> equation < 0)) {
            throw new NumberFormatException();
        }
    }

    private Integer calculateSum(String[] equations) {
        return Arrays.stream(equations).mapToInt(Integer::parseInt).sum();
    }
}
