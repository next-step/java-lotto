package lotto.domain;

/**
 * 인스턴스 풀 개념 도입해보자
 */
public class LottoNumber {

    static final int START_NUM = 1;

    static final int END_NUM = 45;

    private final int number;

    public LottoNumber(final int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(final int number) {
        if (number < START_NUM || number > END_NUM) {
            throw new IllegalArgumentException("로또 번호는 1-45 사이 숫자입니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
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
        return String.valueOf(this.number);
    }
}
