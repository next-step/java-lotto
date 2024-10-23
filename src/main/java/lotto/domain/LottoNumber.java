package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {
    private int lottoNumber;

    public static LottoNumber createLottoNumber(int lottoNumber) {
        validLottoNumberRange(lottoNumber);
        return new LottoNumber(lottoNumber);
    }

    private static void validLottoNumberRange(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException("로또 범위는 1~45의 범위를 가짐");
        }
    }

    private LottoNumber(int number) {
        this.lottoNumber = number;
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.lottoNumber, other.lottoNumber);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }

        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return lottoNumber;
    }
}
