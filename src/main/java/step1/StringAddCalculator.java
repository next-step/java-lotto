package step1;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String formula) {
        if (StringUtils.isBlank(formula)) {
            return 0;
        }

        if (formula.length() == 1){
            return Integer.parseInt(formula);
        }

        return arraySum(formula);
    }

    private static String[] getFormulaSplitArrayBySeparator(String formula) {
        if (formula.contains(",") || formula.contains(":")) {
            return formula.split(Separator.DEFAULT_SEPARATOR);
        }

        return getFormulaSplitArrayByCustomSeparator(formula);
    }

    private static String[] getFormulaSplitArrayByCustomSeparator(String formula) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(formula);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);

        }

        return null;
    }

    private static int arraySum(String formula) {
        String[] array = getFormulaSplitArrayBySeparator(formula);

        int sum = 0;
        for (String number : array) {
            checkNegative(number);
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    private static void checkNegative(String number) {
        if (number.contains("-")) {
            throw new RuntimeException();
        }
    }

}
