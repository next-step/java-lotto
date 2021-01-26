package stringCalculator.domain;

import java.util.Arrays;
import stringCalculator.controller.Validator;
import stringCalculator.util.Utility;

public class StringCalculator {

    public int add(String equation){
        Utility utility = new Utility();

        if (Utility.isEquationEmpty(equation)) {
            return 0;
        }

        String[] equations = utility.splitEquation(equation);
        for (String eq : equations) {
            System.out.println(eq);
        }

        Validator.validatePositiveNum(equations);

        return calculateSum(equations);
    }

    private int calculateSum(String[] equations) {
        return Arrays.stream(equations).mapToInt(Integer::parseInt).sum();
    }
}
