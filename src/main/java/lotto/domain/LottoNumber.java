package lotto.domain;

public class LottoNumber {

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    public static void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < LottoConstant.MIN_LOTTO_NUMBER || lottoNumber > LottoConstant.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 숫자는 " + LottoConstant.MIN_LOTTO_NUMBER + "과 " + LottoConstant.MAX_LOTTO_NUMBER + "사이의 정수 이어야 합니다.");
        }
    }

    public boolean match(int number) {
        return this.lottoNumber == number;
    }

}
