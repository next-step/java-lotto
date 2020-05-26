package step1;

import org.apache.commons.lang3.StringUtils;

public class StringAddCalculator {
    public static int splitAndSum(String formula) {
        if (StringUtils.isBlank(formula)) {
            return 0;
        }

        if (formula.length() == 1){
            return Integer.parseInt(formula);
        }

        if (formula.contains(",")) {
            return arraySum(formula.split(","));
        }

        return 1;
    }

    private static int arraySum(String[] array) {
        int sum = 0;
        for (String s : array) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }

}
