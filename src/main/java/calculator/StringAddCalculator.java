package calculator;

import common.utils.StringUtils;

public class StringAddCalculator {

    public static int splitAndSum(String formula) {
        if (StringUtils.isBlank(formula)) {
            return 0;
        }
        CalculatingNumbers calculatingNumbers = new CalculatingNumbers(formula);
        return calculatingNumbers.sum();
    }
}
