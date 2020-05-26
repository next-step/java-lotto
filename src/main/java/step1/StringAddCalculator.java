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

        return arraySum(getFormulaArrayBySeparator(formula, Separator.DEFAULT_SEPARATOR));
    }

    private static String[] getFormulaArrayBySeparator(String formula, String separator) {
        if (formula.contains(",") || formula.contains(":")) {
            return formula.split(separator);
        }

        return null;
    }

    private static int arraySum(String[] array) {
        int sum = 0;
        for (String s : array) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }

}
