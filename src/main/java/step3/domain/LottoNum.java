package step3.domain;

import java.util.Objects;

public class LottoNum {
    public static final int MIN_LOTTO_NUM = 1;
    public static final int MAX_LOTTO_NUM = 45;
    private final int lottoNum;

    public LottoNum(int lottoNum) {
        validateLottoNumber(lottoNum);
        this.lottoNum = lottoNum;
    }

    private void validateLottoNumber(int lottoNum) {
        if (lottoNum < MIN_LOTTO_NUM || lottoNum > MAX_LOTTO_NUM) {
            throw new RuntimeException("로또의 숫자는 1 - 45 사이만 가능합니다. 현재: " + lottoNum);
        }
    }

    public int getLottoNum() {
        return lottoNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNum lottoNum1 = (LottoNum) o;
        return lottoNum == lottoNum1.lottoNum;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNum);
    }
}
