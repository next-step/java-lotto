package Lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(int i) {
        if(i < MIN_NUMBER || i >MAX_NUMBER) {
            throw new IllegalArgumentException("로또번호는 1부터 45사이 숫자만 생성 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber1 = (LottoNumber) o;
        return lottoNumber == lottoNumber1.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
