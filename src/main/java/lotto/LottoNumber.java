package lotto;

public class LottoNumber implements Comparable<LottoNumber> {
    private int value;

    public LottoNumber(int num) {
        validateLottoNumber(num);
        this.value = num;
    }

    public int value() {
        return value;
    }

    private void validateLottoNumber(int num) {
        if (num <= 0 || num > 45) {
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
