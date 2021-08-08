package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;
    private Integer lottoNumber;

    public LottoNumber(Integer lottoNumber) {
        if (lottoNumber > MAX_NUMBER || lottoNumber < MIN_NUMBER) {
            throw new IllegalArgumentException("로또 넘버는 1~45 사이입니다. 입력 로또 넘버 : " + lottoNumber);
        }
        this.lottoNumber = lottoNumber;
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
