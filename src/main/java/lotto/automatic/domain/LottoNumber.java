package lotto.automatic.domain;

public class LottoNumber implements Comparable {

    private static final int MAX_LOTTO_NUM = 45;
    private static final int MIN_LOTTO_NUM = 1;
    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {

        if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException("로또 번호는 1과 45 사이의 숫자로 구성되어 있어야 합니다.");
        }
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
        return number;
    }

    @Override
    public int compareTo(Object o) {
        LottoNumber other = (LottoNumber) o;
        return Integer.compare(number, other.number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
