package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int calculate(String expression) {
        int ans = 0;
        if (expression == null || expression.isEmpty()) {
            return ans;
        }
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(expression);
        String[] numbers = expression.split(",|:");
        if (matcher.find()) {
            String customDelim = matcher.group(1);
            String exp = matcher.group(2);
            String regex = String.format(",|:|\\%s", customDelim);
            numbers = exp.split(regex);
        }
        for (String number : numbers) {
            int cur = Integer.parseInt(number);
            if (cur < 0) {
                throw new RuntimeException("입력 숫자는 0보다 작을 수 없습니다.");
            }
            ans += cur;
        }
        return ans;
    }
}
