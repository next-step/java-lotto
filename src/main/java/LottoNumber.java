import java.util.Objects;

public class LottoNumber implements Comparable {

    private final int value;

    public LottoNumber(int value) {
        if (value < LottoNumbers.LOTTO_MIN_NUMBER || value > LottoNumbers.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 숫자는 1 ~ 46 사이입니다.");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Object o) {
        LottoNumber obj = (LottoNumber) o;
        if (this.value > obj.value) {
            return 1;
        }
        return -1;
    }
}
