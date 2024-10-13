package step2.domain;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException("로또 번호는 1과 45 사이여야 합니다.");
        }
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.lottoNumber, other.lottoNumber);
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
        return Integer.hashCode(lottoNumber);
    }
}
