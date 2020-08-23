package calculator;

import org.apache.commons.lang3.StringUtils;

public class StringCalculator {
    public static int splitAndSum(String formula) {
        if(validateFormulaEmpty(formula)) {
            return 0;
        }

        return 1;
    }

    private static boolean validateFormulaEmpty(String formula) {
        return StringUtils.isBlank(formula);
    }
}
