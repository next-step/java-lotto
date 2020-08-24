package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static String separator = "[,:]";
    private static List<String> tokens;

    public static int splitAndSum(String formula) {
        if(StringUtils.isBlank(formula)) {
            return 0;
        }
        formula = findCustomSeperator(formula);
        splitFormula(formula);
        isTokensNumber();
        if(tokens.size() == 1) {
            return Integer.parseInt(tokens.get(0));
        }
        return tokens.stream().mapToInt(Integer::parseInt).sum();
    }

    // 커스텀 구분자가 있을 경우 구분자로 사용
    private static String findCustomSeperator(String formula) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(formula);
        if (m.find()) {
            separator = m.group(1);
            return m.group(2);
        }
        return formula;
    }

    // 공식을 구분자로 분할
    private static void splitFormula(String formula) {
        tokens = Arrays.asList(formula.split(separator));
    }

    // 숫자 이외의 값이 있는지 검사
    private static void isTokensNumber() {
        tokens.forEach(StringCalculator::isNumberCheck);
    }

    // 숫자가 아닐 경우 RuntimeException
    public static void isNumberCheck(String value) {
        if(!value.matches("^[0-9]+$")) {
            throw new RuntimeException();
        }
    }
}
