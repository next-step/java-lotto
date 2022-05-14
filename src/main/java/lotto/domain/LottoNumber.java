package lotto.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String INVALID_NUMBER = "숫자는 1 ~ 45 까지의 숫자만 가능합니다. 현재 숫자 : %d";
    private static final String NUMBER_REGEX = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}";
    private static final Pattern pattern = Pattern.compile(NUMBER_REGEX);
    private static final String INVALID_NUMBER_MESSAGE = "정상적인 범위의 숫자 값이 아닙니다.";

    private int number;

    public LottoNumber(int number) {
        if (number > MAX_NUMBER || number < MIN_NUMBER) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER, number));
        }

        this.number = number;
    }

    public LottoNumber(String numberText) {
        validate(numberText);
        this.number = toInt(numberText);
    }

    public int getNumber() {
        return number;
    }

    private void validate(String numberText) {
        System.out.println("numberText = " + numberText);
        Matcher matcher = pattern.matcher(numberText);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }

    private int toInt(String numberText) {
        return Integer.parseInt(numberText);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
