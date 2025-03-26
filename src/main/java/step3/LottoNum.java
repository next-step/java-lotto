package step3;

import java.util.Objects;

public class LottoNum {
    private final int lottoNum;

    public LottoNum(int lottoNum) {
        validateLottoNumber(lottoNum);
        this.lottoNum = lottoNum;
    }

    private void validateLottoNumber(int lottoNum) {
        if (lottoNum < 1 || lottoNum > 45) {
            throw new RuntimeException("로또의 숫자는 1 - 45 사이만 가능합니다.");
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
