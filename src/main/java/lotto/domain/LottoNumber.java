package lotto.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final String VALID_VALUE_PATTERN = "[0-9]+";
    private final int MIN = 1;
    private final int MAX = 45;

    private final int value;

    public LottoNumber(final int value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(final int value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException("1 ~ 45 외의 숫자는 허용되지 않습니다.");
        }
    }

    public static LottoNumber from(final String value) {
        validateToParse(value);
        return new LottoNumber(Integer.parseInt(value.trim()));
    }

    private static void validateToParse(final String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 누락되었습니다.");
        }

        if (!Pattern.matches(VALID_VALUE_PATTERN, value.trim())) {
            throw new IllegalArgumentException("변환할 수 없는 문자가 포함되어 있습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof LottoNumber)) {
            return false;
        }

        return this.value == ((LottoNumber) o).value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.value, o.value);
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }
}
