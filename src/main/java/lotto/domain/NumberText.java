package lotto.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberText {

    private static final String NUMBER_REGEX = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$";
    private static final Pattern pattern = Pattern.compile(NUMBER_REGEX);
    private static final String INVALID_NUMBER_MESSAGE = "정상적인 범위의 숫자 값이 아닙니다. 입력된 숫자 : %s";

    private String numberText;

    public NumberText(String numberText) {
        validate(numberText);
        this.numberText = numberText;
    }

    private void validate(String numberText) {
        Matcher matcher = pattern.matcher(numberText);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_MESSAGE, numberText));
        }
    }

    public String getNumberText() {
        return numberText;
    }

    public int getNumber() {
        return Integer.parseInt(numberText);
    }
}
