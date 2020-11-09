package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final String INVALID_NUMBER_RANGE_ERR_MSG = "로또 숫자가 유효범위를 벗어났습니다.";
    public static final int VALID_MIN_NUMBER = 1;
    public static final int VALID_MAX_NUMBER = 45;

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
        validateNumberRange(this.number);
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    private void validateNumberRange(int number) {
        if (number < VALID_MIN_NUMBER || number > VALID_MAX_NUMBER) {
            throw new IllegalStateException(INVALID_NUMBER_RANGE_ERR_MSG);
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(number, o.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;

        LottoNumber that = (LottoNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
