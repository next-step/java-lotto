package domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int RANGE_FROM = 1;
    private static final int RANGE_TO = 45;
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validate(int lottoNumber) {
        if (!(lottoNumber >= RANGE_FROM && lottoNumber <= RANGE_TO)) {
            throw new IllegalArgumentException("로또 번호의 범위는 1 ~ 45 사이에 있는 값만 허용 합니다.");
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.lottoNumber - lottoNumber.lottoNumber;
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

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
