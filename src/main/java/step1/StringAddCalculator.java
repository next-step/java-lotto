package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static String delimiters = ",|:";

    public int splitAndSum(String text) {
        //null, 빈 문자열 예외처리
        if (isBlank(text)) return 0;

        //커스텀 구분자 찾기
        text = getCustomDelimiters(text);

        //구분자로 구분
        String[] tokens = text.split(delimiters);

        //더해서 결과값 얻기
        int result = sumNumbers(tokens);

        return result;
    }

    private int sumNumbers(String[] tokens) {
        int result = 0;
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            isNegative(number);
            result += Integer.parseInt(token);
        }
        return result;
    }

    private String getCustomDelimiters(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            delimiters = String.join("|", customDelimiter, delimiters);
            text = matcher.group(2);
        }
        return text;
    }

    private void isNegative(int number) {
        if (number < 0) {
           throw new RuntimeException("음수입니다.");
        }
    }

    private boolean isBlank(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }

        return false;
    }
}
