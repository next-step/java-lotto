package lotto.domain;

import lotto.exception.LottoNumberException;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final String NUMBER_RANGE = "^[1-9]{1}$|[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$";
    private static final Pattern RANGE_PATTERN = Pattern.compile(NUMBER_RANGE);

    private final int number;

    public LottoNumber(String input) {
        checkRange(input);
        number = Integer.parseInt(input);
    }

    public LottoNumber(int number) {
        this.number = number;
    }

    private void checkRange(String input) {
        Matcher matcher = RANGE_PATTERN.matcher(input);
        if (!matcher.find()) {
            throw new LottoNumberException();
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

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }
}
