package lotto;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int value;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public LottoNumber(int num) {
        validateLottoNumber(num);
        this.value = num;
    }

    public int value() {
        return value;
    }

    private void validateLottoNumber(int num) {
        if (num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER) {
            throw new RuntimeException("로또번호는 1~45사이여야합니다.");
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
