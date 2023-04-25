package lotto.domain;


public class LottoNumber implements Comparable<LottoNumber>{
    private static final int LOTTO_NUMBER_MINIMUM = 1;
    private static final int LOTTO_NUMBER_MAXIMUM = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if(lottoNumber < LOTTO_NUMBER_MINIMUM || lottoNumber > LOTTO_NUMBER_MAXIMUM) {
            throw new IllegalArgumentException("로또 번호는 1-45 사이의 숫자만 허용됩니다.");
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return lottoNumber - o.lottoNumber;
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
        return lottoNumber;
    }
}
