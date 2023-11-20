package domain;

public class LottoNumber {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateNumberRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private static void validateNumberRange(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(String.format("로또 숫자는 %d과 %d 사이만 가능합니다.", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
