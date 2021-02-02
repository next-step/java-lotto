package stringCalculator.domain;

import java.util.Arrays;
import stringCalculator.util.Utility;

public class StringCalculator {

    private String equation;
    private String[] equations;

    public StringCalculator(String equation) throws RuntimeException {
        if(!Utility.isEquationEmpty(equation)){
            validatePositiveNum(equation);
        }
        this.equation = equation;
    }

    private void splitEquation(String equation) {
        Utility utility = new Utility();
        equations = utility.splitEquation(equation);
    }

    private void splitEquation() {
       splitEquation(this.equation);
    }
    public int add() {
        if (Utility.isEquationEmpty(equation)) {
            return 0;
        }
        splitEquation();
        validatePositiveNum();
        return calculateSum(equations);
    }

    private void validatePositiveNum(String equation) throws RuntimeException {
        splitEquation(equation);
        try {
            if (Arrays.stream(equations).map(Integer::parseInt).anyMatch(num -> num < 0)) {
                throw new RuntimeException();
            }
        } catch(Exception e){
            throw new RuntimeException();
        }
    }

    private void validatePositiveNum() throws RuntimeException {
        validatePositiveNum(this.equation);
    }

    private Integer calculateSum(String[] equations) {
        return Arrays.stream(equations).mapToInt(Integer::parseInt).sum();
    }
}
