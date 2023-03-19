package lotto.domain;

public class LottoNumber {
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        vaildate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void vaildate(int lottoNumber) {
        int minNumber = 1;
        int maxNumber = 45;

        if (lottoNumber < minNumber || maxNumber < lottoNumber) {
            throw new IllegalArgumentException("숫자 범위 벗어남");
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.lottoNumber);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof LottoNumber) {
            return this.lottoNumber == ((LottoNumber) obj).lottoNumber;
        }

        return false;
    }

    @Override
    public String toString() {
        return Integer.toString(lottoNumber);
    }
}
