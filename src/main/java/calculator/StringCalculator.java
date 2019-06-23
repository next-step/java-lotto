package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final int EMPTY_NUM = 0;
    private static final String COMMA_OR_COLON_DELIMITER = ",|:";
    private static final String CUSTOM_REGEX = "//(.)\\n(.*)";
    private static final String NUMBER_REGEX = "^[0-9]*$";

    int add(String val) {
        if (isNull(val) || isEmpty(val)) {
            return EMPTY_NUM;
        }
        String[] numStrings = stringToNumStrings(val);
        int result = 0;
        for (String numStr : numStrings) {
            checkNumberString(numStr);
            result += stringToNum(numStr);
        }
        return result;
    }

    private String[] stringToNumStrings(String val) {
        Matcher matcher = Pattern.compile(CUSTOM_REGEX).matcher(val);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return val.split(COMMA_OR_COLON_DELIMITER);
    }

    private int stringToNum(String val) {
        int num = Integer.parseInt(val);
        checkNegativeNum(num);
        return num;
    }

    private void checkNumberString(String val) throws RuntimeException {
        if (!Pattern.matches(NUMBER_REGEX, val)) {
            throw new RuntimeException("계산할 문자열은 숫자형태만 허용합니다.");
        }
    }

    private void checkNegativeNum(int val) throws RuntimeException {
        if (0 > val) {
            throw new RuntimeException("계산할 문자열에 음수는 허용하지 않습니다.");
        }
    }

    private boolean isNull(String val) {
        if (val == null) {
            return true;
        }
        return false;
    }

    private boolean isEmpty(String val) {
        val = val.trim();
        if (val.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        StringCalculator cal = new StringCalculator();
        System.out.println("[쉼표 또는 콜론 계산기 결과]"+cal.add("1,2:3:4,5"));
        System.out.println("[쉼표 또는 콜론 계산기 결과]"+cal.add("//;\n1;2;3"));
    }
}
