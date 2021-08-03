package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String o) {
        if (!validInputCheck(o)) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(o);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            // 덧셈 구현
            return sumStringAry(tokens);
        }

        return sumStringAry(splitInputString(o));
    }


    private static String[] splitInputString(String o) {
        return o.split(",|:");
    }

    private static int sumStringAry(String[] stringAry) {
        int totalRes = 0;
        for (String s: stringAry) {
            int i = Integer.parseInt(s);
            validIntegerValueCheck(i);
            totalRes += i;
        }
        return totalRes;
    }

    private static void validIntegerValueCheck(int i) {
        if (i < 0) {
            throw new UserCustomException("입력 값은 0보다 커야 합니다.");
        }
    }

    private static boolean validInputCheck(String o) {
        if (o == null || o.isEmpty()) {
            return false;
        }
        return true;
    }

}

class UserCustomException extends RuntimeException {
    public UserCustomException(String message) {
        super(message);
    }
}