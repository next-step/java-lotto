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

        // 일반 구분자
        tokens = Arrays.asList(formula.split(seperator));

        // 숫자 이외의 값이 있는지 검사
        tokens.forEach(StringCalculator::isNumberCheck);

        // 입력 숫자가 하나인지 체크
        if(tokens.size() < 2) {
            return Integer.parseInt(tokens.get(0));
        }

        // 더하기
        return tokens.stream().mapToInt(Integer::parseInt).sum();
    }

    private static boolean validateFormulaEmpty(String formula) {
        return StringUtils.isBlank(formula);
    }

    public static void isNumberCheck(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            throw new RuntimeException();
        }
    }



}
