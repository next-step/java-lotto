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
        if(StringUtils.isBlank(formula)) {
            return 0;
        }
        customSeperator(formula);
        normalSeperator(formula);
        isTokensNumber();
        if(tokens.size() == 1) {
            return Integer.parseInt(tokens.get(0));
        }
        return tokens.stream().mapToInt(Integer::parseInt).sum();
    }

    // 숫자 이외의 값이 있는지 검사
    private static void isTokensNumber() {
        tokens.forEach(StringCalculator::isNumberCheck);
    }

    // 일반 구분자
    private static void normalSeperator(String formula) {
        tokens = Arrays.asList(formula.split(seperator));
    }

    // 커스텀 구분자
    private static void customSeperator(String formula) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(formula);

        if (m.find()) {
            seperator = m.group(1);
            normalSeperator(m.group(2));
        }
    }

    // 숫자가 아닐 경우 RuntimeException
    public static void isNumberCheck(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            throw new RuntimeException();
        }
    }



}
