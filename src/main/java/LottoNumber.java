import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private int lottoNumber;

    public LottoNumber(String lottoNumber) {
        this(Integer.parseInt(lottoNumber));
    }

    public LottoNumber(int lottoNumber) {
        if (lottoNumber < LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException();
        }
        if (lottoNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException();
        }

        this.lottoNumber = lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.lottoNumber - o.lottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
