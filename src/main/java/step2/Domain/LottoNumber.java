package step2.Domain;

import step2.util.StringParser;

import java.util.Objects;
import java.util.regex.Pattern;

public class LottoNumber {

    private static final String LOTTO_NUMBER_REGEX = "^[1-9]$|^[1-3][0-9]$|^4[0-5]$";

    private int number;

    public LottoNumber(String number) {
        this(StringParser.parseStringToInt(number));
    }

    public LottoNumber(int number) {
        check(number);
        this.number = number;
    }

    private void check(int number) {
        if (!Pattern.matches(LOTTO_NUMBER_REGEX, String.valueOf(number))) {
            throw new IllegalArgumentException("로또 번호에 적합하지 않은 숫자입니다.");
        }
    }

    public int getNumber() {
        return number;
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
}
