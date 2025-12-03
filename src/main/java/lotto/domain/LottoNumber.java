package lotto.domain;

public class LottoNumber {
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validate();
        this.lottoNumber = lottoNumber;
    }

    private void validate() {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException();
        }
    }
}
