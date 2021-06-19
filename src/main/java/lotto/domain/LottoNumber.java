package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {
    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        throwIllegalArgumentExceptionLottoRange(lottoNumber);

        this.lottoNumber = lottoNumber;
    }

    private static void throwIllegalArgumentExceptionLottoRange(int lottoNumber) {
        if (lottoNumber < LottoConstants.LOTTO_MIN_NUM || lottoNumber > LottoConstants.LOTTO_MAX_NUM) {
            throw new IllegalArgumentException("로또 번호는 1~45 까지 가능합니다.");
        }
    }


    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(lottoNumber, o.lottoNumber);
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
