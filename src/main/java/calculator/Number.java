package calculator;

import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class Number {

    private static final String NUMBER_PATTERN = "[0-9]+";
    private static final int ZERO = 0;
    private int number;

    public Number(String numberValue) {
        this.number = convertToInt(numberValue);
    }

    public void add(Number y) {
        this.number += y.number;
    }

    private int convertToInt(String numberValue) {
        if (StringUtils.isBlank(numberValue)) {
            return ZERO;
        }

        if (!Pattern.matches(NUMBER_PATTERN, numberValue)) {
            return throwWrongValue();
        }

        int number = Integer.parseInt(numberValue);

        if (number < ZERO) {
            throwWrongValue();
        }

        return number;
    }

    private int throwWrongValue() {
        throw new IllegalArgumentException("0 이상 숫자를 입력해주세요");
    }

    public int getNumber() {
        return number;
    }
}