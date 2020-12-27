package lotto.domain;

public class LottoNumber {

    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;
    private final int number;

    public LottoNumber(int number) {
        if (number < LOTTO_MIN || number > LOTTO_MAX) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지 입니다.");
        }
        this.number = number;
    }

    public String toStringNumber() {
        return String.valueOf(number);
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
