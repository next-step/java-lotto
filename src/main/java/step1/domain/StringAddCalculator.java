package step1.domain;

import step1.exception.CharacterAndMinusCustomException;
import step1.util.StringUtil;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private String value;
    private static final Pattern COMPARE_NUMERIC = Pattern.compile("-?\\d+(\\.\\d+)?");


    public StringAddCalculator(String value) {
        this.value = value;
    }

    public int splitAndSum() {
        if (StringUtil.isEmpty(value)) {
            return 0;
        }

        StringSplit stringSplit = new StringSplit(value);
        String[] numberValue = stringSplit.splitWithDelimeter();
        return Arrays.stream(numberValue).mapToInt(stringNumber -> stringToInt(stringNumber)).sum();
    }

    public int stringToInt(String stringNumber) throws CharacterAndMinusCustomException {
        Matcher m = COMPARE_NUMERIC.matcher(stringNumber);
        if (!m.find()) {
            throw new CharacterAndMinusCustomException("문자입니다.");
        }

        int number = Integer.parseInt(stringNumber);

        if (number < 0) {
            throw new CharacterAndMinusCustomException("음수 사용 불가");
        }
        return number;
    }
}
