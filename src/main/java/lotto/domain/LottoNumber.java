package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final int number;

    public LottoNumber(String number) {
        this(Integer.parseInt(number));
    }

    public LottoNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("1에서 45사이의 숫자만 입력 가능합니다.");
        }
        this.number = number;
    }

    public int number() {
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

    @Override
    public int compareTo(LottoNumber nextLottoNumber) {
        return Integer.compare(this.number, nextLottoNumber.number);
    }
}
