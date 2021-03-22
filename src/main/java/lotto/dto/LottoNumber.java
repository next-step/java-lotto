package lotto.dto;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException();
        }

        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.lottoNumber - lottoNumber.getLottoNumber();
    }
}
