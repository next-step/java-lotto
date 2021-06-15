package lotto.domain;

public class LottoNumber {
    private static int lottoNumber;

    public LottoNumber(int lottoNumber) {
        throwIllegalArgumentExceptionLottoRange(lottoNumber);

        this.lottoNumber = lottoNumber;
    }

    private static void throwIllegalArgumentExceptionLottoRange(int lottoNumber) {
        if (lottoNumber < LottoConstants.LOTTO_MIN_NUM || lottoNumber > LottoConstants.LOTTO_MAX_NUM) {
            throw new IllegalArgumentException("로또 번호는 1~45 까지 가능합니다.");
        }
    }
}
