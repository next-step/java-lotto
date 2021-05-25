package step3.model;

import java.util.Objects;

public final class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String NOT_IN_RANGE = "1~45까지의 숫자를 입력하세요";

    private final Integer number;

    public LottoNumber(Integer number) {
        validation(number);
        this.number = number;
    }

    private void validation(int number) {
        if (!isAvailableRange(number)) {
            throw new IllegalArgumentException(NOT_IN_RANGE);
        }
    }

    private boolean isAvailableRange(int number) {
        return (number >= MIN_NUMBER) && (number <= MAX_NUMBER);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LottoNumber) {
            LottoNumber other = (LottoNumber)obj;
            return this.number.equals(other.number);
        }
        return false;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return (number > other.number) ? 1 : -1;
    }

    public String getStatus() {
        return String.valueOf(number);
    }
}
