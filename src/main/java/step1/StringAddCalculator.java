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

        return 1;
    }

}
