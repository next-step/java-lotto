package lotto.domain.lotto.number;

public class LottoNumber {
    public static final int MIN = 1;
    public static final int MAX = 45;

    private final int number;

    private LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("로또번호는 1 ~ 45 사이여야 합니다");
        }
    }

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
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
        return number;
    }
}
