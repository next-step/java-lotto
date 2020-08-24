package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static String seperator = ",|:";
    private static List<String> tokens;


    public static int splitAndSum(String formula) {
        if(validateFormulaEmpty(formula)) {
            return 0;
        }


        // 커스텀 구분자
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(formula);

        if (m.find()) {
            seperator = m.group(1);
            tokens = Arrays.asList(m.group(2).split(seperator));
        }




        return 1;
    }

    private static boolean validateFormulaEmpty(String formula) {
        return StringUtils.isBlank(formula);
    }

    public void isNumberCheck(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            throw new RuntimeException();
        }
    }



}
