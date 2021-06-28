package lottogame.model;

public class LottoNumber {
    private int lottoNumber;

    final static int LOTTO_MAX_NUM = 45;
    final static int LOTTO_MIN_NUM = 1;

    public LottoNumber(int lottoNumber) {
        validateLottoRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private static void validateLottoRange(int lottoNumber) {
        if (lottoNumber < LOTTO_MIN_NUM || lottoNumber > LOTTO_MAX_NUM) {
            throw new IllegalArgumentException("로또 번호는 1~45 까지 가능합니다.");
        }
    }
}
