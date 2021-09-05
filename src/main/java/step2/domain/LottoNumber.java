package step2.domain;

import step2.vo.LottoNumberValue;

import java.util.Objects;

public class LottoNumber {
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (LottoNumberValue.isRange(lottoNumber)) {
            this.lottoNumber = lottoNumber;
            return;
        }
        throw new RuntimeException("1~45 사이의 숫자만 생성 가능합니다.");
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
